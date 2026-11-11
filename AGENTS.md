# AGENTS.md

This file provides guidance to coding agents (Claude Code, Codex, ...) when working with code in this repository.

## Commands

```bash
# Run the application: http://localhost:8080, erupt / erupt
mvn spring-boot:run          # or run com.example.demo.ExampleApplication#main

# Build
mvn clean package

# Tests / a single test method
mvn test
mvn test -Dtest=ExampleApplicationTests#query
```

Java 17+, Maven 3.6+ (no wrapper), parent `spring-boot-starter-parent` 3.5.13, erupt at `erupt.version`
2.2.0 in `pom.xml`. The only test class, `ExampleApplicationTests`, is a `@SpringBootTest` that boots the
whole application with `src/main/resources/application.yml` (there is no test configuration) and shows an
`EruptDao.lambdaQuery` call; it asserts nothing.

## What this is

The official example project of the erupt framework: a runnable Spring Boot application
(`com.example.demo.ExampleApplication`, annotated `@EruptScan` and `@EntityScan`), not a library. It
demonstrates the framework's features with as little code as possible; there is no business logic to
preserve beyond the demonstrations themselves.

erupt modules in `pom.xml`: `erupt-admin` and `erupt-web` (the required pair), plus optional ones the pom
marks as removable: `erupt-cloud-server`, `erupt-job`, `erupt-monitor`, `erupt-magic-api`, `erupt-ai`,
`erupt-ai-claw`, `erupt-terminal`, `erupt-websocket`, `erupt-tpl` with `erupt-tpl-ui.element-ui`, and
`velocity-engine-core` for the Velocity template demo. H2 and the MySQL driver are both on the classpath.

## Architecture

- **No module registration.** The repo has no `EruptModule` and seeds no menus. The example classes become
  pages by hand: in the running admin, under System Management → Menu Maintenance, add a menu whose
  "type value" is the class name (`Simple`, `Article`, `Complex`, ...) or a template path
  (`erupt.html`, `velocity.vm`, `freemarker.ftl`, `thymeleaf.html`). README.md lists every example with
  its menu type and type value; keep that table in step when adding or renaming an example.
- **Models (`model/`).** JPA entities with `@Erupt` / `@EruptField`, tables created by
  `spring.jpa.generate-ddl`:
  - `Simple`, `Article`, `TreeView`, `Component`: basic table, rich text and attachments, tree view, the
    component gallery (with `handler/ComponentDataProxy` and `handler/AutoCompleteHandlerImpl`).
  - `CurdDemo`: a model that is its own `DataProxy`.
  - `complex/`: `Complex` with dynamic choices, custom row operations (`fun/OperationHandlerImpl`),
    one-to-many tabs, dialogs and `fun/ComplexDataProxy`. The menu of type button with value `ComplexBtn`
    controls the visibility of its multi-row operation.
  - `blog/` and `mall/`: two small sample domains (blog, categories, tags, pictures, links; goods,
    categories, coupons).
- **Template pages.** `action/` holds `@EruptTpl` classes whose `@TplAction` methods bind data to the
  templates in `src/main/resources/tpl/` (Freemarker, Velocity, Thymeleaf, and the static `erupt.html`).
  The Thymeleaf example needs the thymeleaf dependency, which the pom does not include.
- **Plain Spring code next to erupt.** `controller/TestController` is an ordinary `@RestController`
  (`/list`) that queries through `EruptDao`.
- **Frontend customisation.** `src/main/resources/public/`: `app.js` (`window.eruptSiteConfig`: title,
  map key and other site settings), `app.css`, `home.html`, `favicon.ico`. The map component needs your
  own `amapKey` there; do not copy the key into other files.
- **Language.** Model names, field titles and comments in this repo are Chinese, and
  `erupt.default-locales` is `zh-CN`.

## Local data and configuration

`src/main/resources/application.yml`:
- `spring.datasource.url` is an H2 file database `./erupt` in the working directory (`erupt.mv.db`,
  `erupt.lock.db`, not git-ignored); a commented-out MySQL block shows the alternative.
- `erupt.upload-path` and `magic-api.resource.location` point at Windows paths (`D:/erupt/...`). On other
  systems they resolve to a `D:` directory inside the repo; README.md says to set `erupt.upload-path` to a
  writable local directory when uploads fail.
- `spring.data.redis.*` points at a local Redis (`127.0.0.1:6379`); no `erupt.redis-session` switch is set
  in this file.

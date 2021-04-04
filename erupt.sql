# Erupt Menu Data SQL
# 请首次启动后生成基础表结构后，再执行该sql文件

insert into e_upms_menu(create_time, code, name, sort, status, type, value, parent_menu_id)
values (now(), '', '', 100, 1, 'table', '', null)
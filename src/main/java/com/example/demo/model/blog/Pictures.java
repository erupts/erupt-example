package com.example.demo.model.blog;

import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.fun.DataProxy;
import xyz.erupt.annotation.sub_erupt.LinkTree;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.ViewType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.core.prop.EruptProp;
import xyz.erupt.upms.model.base.HyperModel;

import jakarta.annotation.Resource;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author YuePeng
 * date 2020-05-28
 */
@Erupt(
        name = "图片管理",
        dataProxy = Pictures.class,
        power = @Power(edit = false),
        linkTree = @LinkTree(dependNode = true, field = "picturesCategory")
)
@Table(name = "blog_picture")
@Entity
public class Pictures extends HyperModel implements DataProxy<Pictures> {

    @EruptField(
            views = {
                    @View(title = "缩略图", type = ViewType.IMAGE)
            },
            edit = @Edit(title = "图片地址", notNull = true, type = EditType.ATTACHMENT)
    )
    private String filePath;

    @EruptField(
            views = @View(title = "大小", template = "(value/1024/1024).toFixed(2) + 'MB'")
    )
    private Integer sizes;

    @EruptField(
            views = @View(title = "宽度"),
            edit = @Edit(title = "宽度", show = false, search = @Search(vague = true))
    )
    private Integer width;

    @EruptField(
            views = @View(title = "高度"),
            edit = @Edit(title = "高度", show = false, search = @Search(vague = true))
    )
    private Integer height;

    @EruptField(
            views = {
                    @View(title = "备注")
            },
            edit = @Edit(title = "图片备注", type = EditType.TEXTAREA)
    )
    private String remark;

    @ManyToOne
    private PicturesCategory picturesCategory;

    @Transient
    @Resource
    private EruptProp eruptProp;

    @Override
    public void beforeAdd(Pictures pictures) {
        File file = new File(eruptProp.getUploadPath() + pictures.filePath);
        try {
            BufferedImage bufferedImage = ImageIO.read(new FileInputStream(file));
            pictures.setHeight(bufferedImage.getHeight());
            pictures.setWidth(bufferedImage.getWidth());
            pictures.setSizes((int) file.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Integer getSizes() {
        return sizes;
    }

    public void setSizes(Integer sizes) {
        this.sizes = sizes;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}

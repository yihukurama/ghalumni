package com.ghds.alumni.app.constant;

/**
 * 功能描述: 图片类型
 *
 * @Author: 蔡伟浩
 * @Date: 2017/1/13 14:19
 */
public enum ImageEnum {
    COMM_IMG_LINK(0, "commImgLink", "定损图"),
    OTHER_IMG(199, "other", "其他"),

    ;

    //类型
    private int type;
    //标识
    private String tag;
    //说明
    private String explain;

    ImageEnum(int type, String tag, String explain) {
        this.type = type;
        this.tag = tag;
        this.explain = explain;
    }

    public int getType() {
        return type;
    }

    public String getTag() {
        return tag;
    }

    public String getExplain() {
        return explain;
    }

    public static ImageEnum buildByType(Integer type) {
        if (type == null) {
            return null;
        }
        for (ImageEnum imageEnum : ImageEnum.values()) {
            if (imageEnum.getType() == type) {
                return imageEnum;
            }
        }
        return null;
    }


}

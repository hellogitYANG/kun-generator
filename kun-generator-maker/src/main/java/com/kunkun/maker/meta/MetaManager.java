package com.kunkun.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

public class MetaManager {
    public static volatile Meta meta;
    private MetaManager(){

    }
    public  static Meta getMetaObject(){
        if(meta==null){
            synchronized (MetaManager.class){
                if(meta==null){
                    meta=initMeta();
                }
            }
        }
        return meta;
    }

    private static Meta initMeta() {
        String metaJson = ResourceUtil.readUtf8Str("springboot-init-meta.json");
        Meta newMeta = JSONUtil.toBean(metaJson, Meta.class);
        Meta.FileConfig fileConfig = newMeta.getFileConfig();
        //校验和处理默认值
        MetaValidator.doValiAndFill(newMeta);
        return newMeta;
    }
}

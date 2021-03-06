package com.business.code.generator;

import com.business.code.generator.model.TableClass;
import org.apache.commons.lang3.StringUtils;

import java.util.Properties;

/**
 * @author lusi
 */
public class ServiceImplTemplatePlugin extends CommonTemplatePlugin {


    public static final String GENERATOR_SERVICE_FTL = "generator/serviceImpl.ftl";

    private static final String SUFFIX = "ServiceImpl";

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        setTemplatePath(GENERATOR_SERVICE_FTL);
        setFileName("${tableClass.simpleUpName}" + SUFFIX + ".java");
        setTargetPackage(properties.getProperty("targetPackage"
                , properties.getProperty("targetServiceImplPackage", this.getBasePackage() + ".service.impl")));
        super.properties.put("isImportBaseServiceImpl", isImport((String) properties.get("baseServiceImpl"),getTargetPackage()));

    }



    @Override
    public String getJavaReference(TableClass tableClass) {
        return (getTargetProject() + "/" + getTargetPackage() + "/"
                + tableClass.getSimpleUpName() + SUFFIX).replace(".", "/")+".java";
    }

}

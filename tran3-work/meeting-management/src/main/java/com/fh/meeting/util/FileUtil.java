package com.fh.meeting.util;

import com.fh.meeting.common.SystemConstant;
import com.itextpdf.text.pdf.BaseFont;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

public class FileUtil {

    public static void downloadExcel(HttpServletResponse response, Map map, String fileName) {
        //map.put("productList", list);
        Configuration configuration = new Configuration();
        //configuration.setDefaultEncoding("utf-8");
        //有两种方式获取你的模板，模板在项目中时用第一个，模板在本地时用第二个。
        //注意：两种方式的路径都只需要写到模板的上一级目录
        configuration.setClassForTemplateLoading(FileUtil.class, SystemConstant.TEMPLATE_ROOT_PATH);
        //  configuration.setDirectoryForTemplateLoading(new File("C:/"));
        //File outFile = new File("D:/outFile/"+Math.random()*10000+".xls");//输出路径
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + UUID.randomUUID().toString() + ".xlsx");
        Template t = null;
        OutputStream out = null;
        OutputStreamWriter writer = null;
        try {
            t = configuration.getTemplate(fileName, "utf-8"); //文件名，获取模板
            out = response.getOutputStream();
            writer = new OutputStreamWriter(out, "utf-8");
            t.process(map, writer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (writer != null) {
                    writer.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void downloadWord(HttpServletResponse response, Map map, String fileName) {
        //map.put("productList", list);
        Configuration configuration = new Configuration();
        //configuration.setDefaultEncoding("utf-8");
        //有两种方式获取你的模板，模板在项目中时用第一个，模板在本地时用第二个。
        //注意：两种方式的路径都只需要写到模板的上一级目录
        configuration.setClassForTemplateLoading(FileUtil.class, SystemConstant.TEMPLATE_ROOT_PATH);
        //  configuration.setDirectoryForTemplateLoading(new File("C:/"));
        //File outFile = new File("D:/outFile/"+Math.random()*10000+".xls");//输出路径
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + UUID.randomUUID().toString() + ".docx");
        Template t = null;
        OutputStream out = null;
        OutputStreamWriter writer = null;
        try {
            t = configuration.getTemplate(fileName, "utf-8"); //文件名，获取模板
            out = response.getOutputStream();
            writer = new OutputStreamWriter(out, "utf-8");
            t.process(map, writer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (writer != null) {
                    writer.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void downloadPdf(HttpServletResponse response, Map map) {
        ByteArrayOutputStream baos = null;
        OutputStream out = null;
        try {

            baos = createPDF(map, SystemConstant.TEMPLATE_PDF_PATH);
            // 设置响应消息头，告诉浏览器当前响应是一个下载文件
            response.setContentType( "application/x-msdownload");
            // 告诉浏览器，当前响应数据要求用户干预保存到文件中，以及文件名是什么 如果文件名有中文，必须URL编码
            String fileName = URLEncoder.encode("商品详情.pdf", "UTF-8");
            response.setHeader( "Content-Disposition", "attachment;filename=" + fileName);
            out = response.getOutputStream();
            baos.writeTo(out);
            baos.close();
        } catch (Exception e) {
            e.printStackTrace();

        } finally{
            try {
                if(baos != null){
                    baos.close();
                }
                if(out != null){
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static ByteArrayOutputStream createPDF(Map<String, Object> data, String templateFileName) throws Exception {
        // 创建一个FreeMarker实例, 负责管理FreeMarker模板的Configuration实例
        Configuration cfg = new Configuration();
        // 指定FreeMarker模板文件的位置
        cfg.setClassForTemplateLoading(FileUtil.class, SystemConstant.TEMPLATE_ROOT_PATH);
        ITextRenderer renderer = new ITextRenderer();
        OutputStream out = new ByteArrayOutputStream();
        try {
            // 设置 css中 的字体样式（暂时仅支持宋体和黑体） 必须，不然中文不显示
            renderer.getFontResolver().addFont("/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            // 设置模板的编码格式
            cfg.setEncoding(Locale.CHINA, "UTF-8");
            // 获取模板文件
            Template template = cfg.getTemplate(templateFileName, "UTF-8");
            StringWriter writer = new StringWriter();

            // 将数据输出到html中
            template.process(data, writer);
            writer.flush();

            String html = writer.toString();
            // 把html代码传入渲染器中
            renderer.setDocumentFromString(html);

            // 设置模板中的图片路径 （这里的images在resources目录下） 模板中img标签src路径需要相对路径加图片名 如<img src="images/xh.jpg"/>
            //String url = FileUtil.class.getClassLoader().getResource("images").toURI().toString();
           // renderer.getSharedContext().setBaseURL(url);
            renderer.layout();

            renderer.createPDF(out, false);
            renderer.finishPDF();
            out.flush();
            return (ByteArrayOutputStream) out;
        } finally {
            if (out != null) {
                out.close();
            }
        }

    }
}

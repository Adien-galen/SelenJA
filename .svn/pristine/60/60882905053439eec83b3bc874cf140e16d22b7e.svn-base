package test.java.utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

/**
 * 作者：灵枢 on 2017/3/1 10:19
 * <p/>
 * 邮箱：404110318@qq.com
 * <p/>
 * 描述：对xml文件的读写
 */
public class XmlUtils {

    private static SAXReader reader = new SAXReader();// 创建解析器

    public static String readXml(String addr,String elementName){
        String elementValue = null;
        try {
            Document doc = reader.read(addr);
            Element rootElement = doc.getRootElement();
            List<Element> elements = rootElement.elements();
            for (Element element : elements) {
                if (element.getName().equals(elementName)) {
                    elementValue = element.getText();
//                    System.out.println(elementName + ":" + elementValue);
                }
            }

        }catch (Exception e) {
                e.printStackTrace();
         }
        return elementValue;
    }

    public static void writeXml(String addr,String elementName,String elementValue){

        try {
            // 调用读方法，得到Document
            Document doc = reader.read(addr);
            //得到根元素
            Element rootElement = doc.getRootElement();
            //向根元素中添加一个名为elementName的元素！并返回这个元素
            Element ele = rootElement.addElement(elementName);

            //给该元素添加值
            ele.setText(elementValue);

            // 创建目标输出流，它需要与xml文件绑定
            Writer out = new PrintWriter(addr,"UTF-8");
            // 创建格式化器
            OutputFormat format = new OutputFormat("\t",true);
            format.setTrimText(true);//先干掉原来的空白(\t和换行和空格)！

            // 创建XMLWrtier
            XMLWriter writer = new XMLWriter(out,format);
            // 调用它的写方法，把document对象写到out流中。
            writer.write(doc);
            // 关闭流
            out.close();
            writer.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void removeXml(String addr,String elementName){

        try {
            // 调用读方法，得到Document
            Document doc = reader.read(addr);
            //得到根元素
            Element rootElement = doc.getRootElement();
            //移除elementName元素
            List<Element> elements = rootElement.elements();
            for (Element element : elements) {
                if (element.getName().equals(elementName)) {
                    rootElement.remove(element);
                }
            }

            // 创建目标输出流，它需要与xml文件绑定
            Writer out = new PrintWriter(addr,"UTF-8");
            // 创建格式化器
            OutputFormat format = new OutputFormat("\t",true);
            format.setTrimText(true);//先干掉原来的空白(\t和换行和空格)！

            // 创建XMLWrtier
            XMLWriter writer = new XMLWriter(out,format);
            // 调用它的写方法，把document对象写到out流中。
            writer.write(doc);
            // 关闭流
            out.close();
            writer.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 删除根节点外的所有其它节点
     * @param addr
     */
    public static void removeAll(String addr){

        try {
            // 调用读方法，得到Document
            Document doc = reader.read(addr);
            //得到根元素
            Element rootElement = doc.getRootElement();
            //移除elementName元素
            List<Element> elements = rootElement.elements();
            for (Element element : elements) {
                rootElement.remove(element);
            }
            // 创建目标输出流，它需要与xml文件绑定
            Writer out = new PrintWriter(addr,"UTF-8");
            // 创建格式化器
            OutputFormat format = new OutputFormat("\t",true);
            format.setTrimText(true);//先干掉原来的空白(\t和换行和空格)！

            // 创建XMLWrtier
            XMLWriter writer = new XMLWriter(out,format);
            // 调用它的写方法，把document对象写到out流中。
            writer.write(doc);
            // 关闭流
            out.close();
            writer.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}

package com.ckt.jmetertools.functions;

public class MailTest {
    public static void main(String[] args) throws Exception {
        MailSender mailSender = MailSender.getInstance();
        
        MailInfo info = new MailInfo();
        info.setMailHost("hwsmtp.qiye.163.com");
        info.setMailPort("465");
        info.setUsername("qiang.zhang@ck-telecom.com");
        info.setPassword("zhangqiang@9090");
        info.setNotifyTo("qiang.zhang@ck-telecom.com");
        info.setNotifyCc("tyokyo@126.com");
        info.setSubject("java send mail test");
        
        StringBuffer content=new StringBuffer();
        content.append("<html>");
        content.append("<p><h3 style=\"color:Blank;font-weight:bold;\">Notice: </h3>");
        content.append("<span style=\"color:Blank;font-size:10pt;font-weight:bold;\">There are some fail cases if you recivie this email, pls check the server!<br>");
        content.append("Here is the report for Sioeye2.0 Server Auto Test.</span></p>");
        //result table
        //content.append(com.main.ServerTestClient.reportUtil.getResultbuf().toString());
        //Fail Item
        //content.append(com.main.ServerTestClient.reportUtil.getApibuf_fail().toString());
        content.append("中文编码测试，看是不是乱码");
        content.append("</html>");
        
        
        info.setContent(content.toString());
        info.setAttachFileNames(new String[]{"D:\\soft\\Jmeter\\demo\\lib\\activation.jar"});//添加附件
        
        //MailInfo mailInfo = mailSender.setMailInfo();
        mailSender.sendHtmlMail(info, 3);
    }
}

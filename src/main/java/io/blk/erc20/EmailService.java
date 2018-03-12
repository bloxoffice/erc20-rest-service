package io.blk.erc20;

import com.sendgrid.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import static com.sendgrid.SendGrid.*;
/**
 * Created by mamu on 3/12/18.
 */
@Service
public class EmailService {

    private static final String FROM_EMAIL = "contact@bloxoffice.io";

    public void sendJoinListEmail(String emailAddress) throws IOException{
        Email from = new Email("contact@bloxoffice.io");
        String subject = "Greetings from Bloxoffice";
        Email to = new Email(emailAddress);
        Content content = new Content("text/html", template());
        Mail mail = new Mail(from, subject, to, content);

        //SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
    }


    //Move the html to a file
    private String template(){
        String htmlTemplate = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html style=\"width:100%;font-family:arial, 'helvetica neue', helvetica, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0;\">\n" +
                " <head> \n" +
                "  <meta charset=\"UTF-8\"> \n" +
                "  <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\"> \n" +
                "  <meta name=\"x-apple-disable-message-reformatting\"> \n" +
                "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> \n" +
                "  <meta content=\"telephone=no\" name=\"format-detection\"> \n" +
                "  <title></title> \n" +
                "  <!--[if (mso 16)]>\n" +
                "    <style type=\"text/css\">\n" +
                "    a {text-decoration: none;}\n" +
                "    </style>\n" +
                "    <![endif]--> \n" +
                "  <!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]--> \n" +
                "  <style>\n" +
                "@media only screen and (max-width: 600px) {p, ul li, ol li, a { font-size: 16px } h1 { font-size: 30px; text-align: center } h2 { font-size: 26px; text-align: center } h3 { font-size: 20px; text-align: center } h1 a { font-size: 30px } h2 a { font-size: 26px } h3 a { font-size: 20px } .es-menu td a { font-size: 16px !important } .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a { font-size: 16px } .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a { font-size: 16 px } .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a { font-size: 12px } *[class=\"gmail-fix\"] { display: none !important } .es-m-txt-c, .es-m-txt-c h1, .es-m-txt-c h2, .es-m-txt-c h3 { text-align: center !important } .es-m-txt-r, .es-m-txt-r h1, .es-m-txt-r h2, .es-m-txt-r h3 { text-align: right !important } .es-m-txt-l, .es-m-txt-l h1, .es-m-txt-l h2, .es-m-txt-l h3 { text-align: left !important } .es-m-txt-r a img, .es-m-txt-c a img, .es-m-txt-l a img { display: inline !important } .es-button-border { display: block !important } .es-button { font-size: 20px !important; display: block !important; border-width: 10px 0px 10px 0px !important } .es-btn-fw { border-width: 10px 0px !important; text-align: center !important } .es-adaptive table, .es-btn-fw, .es-btn-fw-brdr, .es-left, .es-right { width: 100% !important } .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header { width: 100% !important; max-width: 600px !important } .es-adapt-td { display: block !important; width: 100% !important } .adapt-img { width: 100% !important; height: auto !important } .es-m-p0 { padding: 0px !important } .es-m-p0r { padding-right: 0px !important } .es-m-p0l { padding-left: 0px !important } .es-m-p0t { padding-top: 0px !important } .es-m-p0b { padding-bottom: 0 !important } .es-m-p20b { padding-bottom: 20px !important } .es-hidden { display: none !important } table.es-table-not-adapt, .esd-block-html table { width: auto !important } table.es-social { display: inline-block !important } table.es-social td { display: inline-block !important } }\n" +
                "\n" +
                "</style> \n" +
                "  <style>\n" +
                "\n" +
                "#outlook a {\n" +
                "\tpadding: 0;\n" +
                "}\n" +
                ".ExternalClass {\n" +
                "\twidth: 100%;\n" +
                "}\n" +
                ".ExternalClass,\n" +
                ".ExternalClass p,\n" +
                ".ExternalClass span,\n" +
                ".ExternalClass font,\n" +
                ".ExternalClass td,\n" +
                ".ExternalClass div {\n" +
                "\tline-height: 100%;\n" +
                "}\n" +
                ".es-button {\n" +
                "\tmso-style-priority: 100 !important;\n" +
                "\ttext-decoration: none !important;\n" +
                "}\n" +
                "a[x-apple-data-detectors] {\n" +
                "\tcolor: inherit !important;\n" +
                "\ttext-decoration: none !important;\n" +
                "\tfont-size: inherit !important;\n" +
                "\tfont-family: inherit !important;\n" +
                "\tfont-weight: inherit !important;\n" +
                "\tline-height: inherit !important;\n" +
                "}\n" +
                "@-ms-viewport {\n" +
                "\twidth: device-width;\n" +
                "}\n" +
                "img + div {\n" +
                "   display:none;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "</style> \n" +
                " </head> \n" +
                " <body style=\"width:100%;font-family:arial, 'helvetica neue', helvetica, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0;\"> \n" +
                "  <div class=\"es-wrapper-color\" style=\"background-color:rgb(246, 246, 246);\"> \n" +
                "   <!--[if gte mso 9]>\n" +
                "    <v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
                "        <v:fill type=\"tile\" src=\"\" color=\"#f6f6f6\"></v:fill>\n" +
                "    </v:background>\n" +
                "<![endif]--> \n" +
                "   <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-wrapper\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top;\"> \n" +
                "    <tbody> \n" +
                "     <tr style=\"border-collapse:collapse;\"> \n" +
                "      <td valign=\"top\" style=\"padding:0;Margin:0;\"> \n" +
                "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-header\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top;\"> \n" +
                "        <tbody> \n" +
                "         <tr style=\"border-collapse:collapse;\"> \n" +
                "          <td align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
                "           <table class=\"es-header-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;\"> \n" +
                "            <tbody> \n" +
                "             <tr style=\"border-collapse:collapse;\"> \n" +
                "              <td class=\"es-p20b es-p20r es-p20l\" align=\"left\" style=\"padding:0;Margin:0;padding-bottom:20px;padding-left:20px;padding-right:20px;\"> \n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
                "                <tbody> \n" +
                "                 <tr style=\"border-collapse:collapse;\"> \n" +
                "                  <td width=\"560\" align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;\"> \n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
                "                    <tbody> \n" +
                "                     <tr style=\"border-collapse:collapse;\"> \n" +
                "                      <td align=\"center\" style=\"padding:0;Margin:0;\"> <a href=\"http://stripo.email\" target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:14px;text-decoration:underline;color:rgb(19, 118, 200);\"><img src=\"https://ukzb.stripocdn.email/content/guids/985f6af3-abe9-4217-a6a2-9dcb2baa2c38/images/7361520870775547.png\" alt=\"\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic;\" width=\"176\"></a> </td> \n" +
                "                     </tr> \n" +
                "                    </tbody> \n" +
                "                   </table> </td> \n" +
                "                 </tr> \n" +
                "                </tbody> \n" +
                "               </table> </td> \n" +
                "             </tr> \n" +
                "            </tbody> \n" +
                "           </table> </td> \n" +
                "         </tr> \n" +
                "        </tbody> \n" +
                "       </table> \n" +
                "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;\"> \n" +
                "        <tbody> \n" +
                "         <tr style=\"border-collapse:collapse;\"> \n" +
                "          <td align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
                "           <table bgcolor=\"#ffffff\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:rgb(255, 255, 255);\"> \n" +
                "            <tbody> \n" +
                "             <tr style=\"border-collapse:collapse;\"> \n" +
                "              <td class=\"es-p20\" align=\"left\" style=\"padding:20px;Margin:0;\"> \n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
                "                <tbody> \n" +
                "                 <tr style=\"border-collapse:collapse;\"> \n" +
                "                  <td width=\"560\" align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;\"> \n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
                "                    <tbody> \n" +
                "                     <tr style=\"border-collapse:collapse;\"> \n" +
                "                      <td align=\"left\" class=\"es-p15b\" style=\"padding:0;Margin:0;padding-bottom:15px;\"> <h2 style=\"Margin:0;line-height:120%;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:24px;font-style:normal;font-weight:normal;color:rgb(51, 51, 51);\">Welcome to Bloxoffice,</h2></td> \n" +
                "                     </tr> \n" +
                "                     <tr style=\"border-collapse:collapse;\"> \n" +
                "                      <td align=\"left\" style=\"padding:0;Margin:0;\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:150%;color:rgb(51, 51, 51);\">Thank you for joining the whitelist, we will keep you posted</p><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:150%;color:rgb(51, 51, 51);\">when our pre-sale is live.</p><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:150%;color:rgb(51, 51, 51);\"><br></p><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:150%;color:rgb(51, 51, 51);\">Warm Regards,</p><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:150%;color:rgb(51, 51, 51);\">BloxOffice Team.</p><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:150%;color:rgb(51, 51, 51);\">www.bloxoffice.io&nbsp;&nbsp;</p></td> \n" +
                "                     </tr> \n" +
                "                    </tbody> \n" +
                "                   </table> </td> \n" +
                "                 </tr> \n" +
                "                </tbody> \n" +
                "               </table> </td> \n" +
                "             </tr> \n" +
                "            </tbody> \n" +
                "           </table> </td> \n" +
                "         </tr> \n" +
                "        </tbody> \n" +
                "       </table> \n" +
                "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;\"> \n" +
                "        <tbody> \n" +
                "         <tr style=\"border-collapse:collapse;\"> \n" +
                "          <td align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
                "           <table class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:rgb(255, 255, 255);\"> \n" +
                "            <tbody> \n" +
                "             <tr style=\"border-collapse:collapse;\"> \n" +
                "              <td align=\"left\" style=\"padding:0;Margin:0;\"> \n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
                "                <tbody> \n" +
                "                 <tr style=\"border-collapse:collapse;\"> \n" +
                "                  <td width=\"600\" align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;\"> \n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
                "                    <tbody> \n" +
                "                     <tr style=\"border-collapse:collapse;\"> \n" +
                "                      <td align=\"center\" height=\"40\" bgcolor=\"#f6f6f6\" style=\"padding:0;Margin:0;\"> </td> \n" +
                "                     </tr> \n" +
                "                    </tbody> \n" +
                "                   </table> </td> \n" +
                "                 </tr> \n" +
                "                </tbody> \n" +
                "               </table> </td> \n" +
                "             </tr> \n" +
                "            </tbody> \n" +
                "           </table> </td> \n" +
                "         </tr> \n" +
                "        </tbody> \n" +
                "       </table> \n" +
                "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;\"> \n" +
                "        <tbody> \n" +
                "         <tr style=\"border-collapse:collapse;\"> \n" +
                "          <td align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
                "           <table class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:rgb(255, 255, 255);\"> \n" +
                "            <tbody> \n" +
                "             <tr style=\"border-collapse:collapse;\"> \n" +
                "              <td align=\"left\" style=\"padding:0;Margin:0;\"> \n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
                "                <tbody> \n" +
                "                 <tr style=\"border-collapse:collapse;\"> \n" +
                "                  <td width=\"600\" align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;\"> \n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
                "                    <tbody> \n" +
                "                     <tr style=\"border-collapse:collapse;\"> \n" +
                "                      <td align=\"center\" height=\"40\" bgcolor=\"#f6f6f6\" style=\"padding:0;Margin:0;\"> </td> \n" +
                "                     </tr> \n" +
                "                    </tbody> \n" +
                "                   </table> </td> \n" +
                "                 </tr> \n" +
                "                </tbody> \n" +
                "               </table> </td> \n" +
                "             </tr> \n" +
                "            </tbody> \n" +
                "           </table> </td> \n" +
                "         </tr> \n" +
                "        </tbody> \n" +
                "       </table> </td> \n" +
                "     </tr> \n" +
                "    </tbody> \n" +
                "   </table> \n" +
                "  </div>  \n" +
                " </body>\n" +
                "</html>";
        return htmlTemplate;
    }

}



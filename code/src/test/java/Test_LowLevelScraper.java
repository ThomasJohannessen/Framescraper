//import Scraper.Scraper;
//import ParseException;
//import SoupNode;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class Test_LowLevelScraper {
//    String siteContent = "<body id=\"hi\" class=\"class1\">Hei jeg hedder dorte <img id=\"bestebildet\" class=\"bestebildene\" src=\"img_girl.jpg\" alt=\"Girl in a jacket\" width=\"500\" height=\"600\"> <video id=\"bestevideoen\" class=\"bestevideoene\" src=\"video_girl.mp4\" alt=\"Girl in a jacket\" width=\"500\" height=\"600\"><p lang=\"no\" id=\"para\" class=\"testClass\">yo who<a src=\"blabal\" target=\"_blank\" class=\"testClass\" href=\"https://www.w3schools.com/\" >https://www.w3schools.com/</a><p>yo mama</p></p>og min mor er borte <a href=\"https://www.test.com/\"> Testloink2 </a><img class=\"bestebildene\" src=\"www.google.com/hjelp/img_boy.jpg\" alt=\"Girl in an jacket\" width=\"500\" height=\"600\"> <video src=\"www.google.com/hjelp/video_boy.wma\" alt=\"Boy in a jacket\" width=\"500\" height=\"600\"> <h1 id=\"header1\">chIld, of CHIld.</h1></body>";
//    Scraper sc;
//
//    {
//        try {
//            sc = new Scraper(siteContent, true);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }
//
//    SoupNode rootNode = sc.getRoot();
//
//    @Test
//    public void createsTreeCorrectly() {
//        String expectedOutput = "Scraper.SoupNode{tag='body', attributes=[id, class], stringChildren=[Hei jeg hedder dorte ], nodeChildren= \n\t" +
//                "[Scraper.SoupNode{tag='img', attributes=[id, class, src, alt, width, height], stringChildren=[ ], nodeChildren= \n\t" +
//                "[Scraper.SoupNode{tag='video', attributes=[id, class, src, alt, width, height], stringChildren=[og min mor er borte ], nodeChildren= \n\t" +
//                "[Scraper.SoupNode{tag='p', attributes=[lang, id, class], stringChildren=[yo who], nodeChildren= \n\t" +
//                "[Scraper.SoupNode{tag='a', attributes=[src, target, class, href], stringChildren=[https://www.w3schools.com/], nodeChildren= \n\t" +
//                "[]}, Scraper.SoupNode{tag='p', attributes=[], stringChildren=[yo mama], nodeChildren= \n\t" +
//                "[]}]}, Scraper.SoupNode{tag='a', attributes=[href], stringChildren=[ Testloink2 ], nodeChildren= \n\t" +
//                "[]}, Scraper.SoupNode{tag='img', attributes=[class, src, alt, width, height], stringChildren=[ ], nodeChildren= \n\t" +
//                "[Scraper.SoupNode{tag='video', attributes=[src, alt, width, height], stringChildren=[ ], nodeChildren= \n\t" +
//                "[Scraper.SoupNode{tag='h1', attributes=[id], stringChildren=[chIld, of CHIld.], nodeChildren= \n\t" +
//                "[]}]}, Scraper.SoupNode{tag='', attributes=[body], stringChildren=[], nodeChildren= \n\t" +
//                "[]}]}]}]}]}";
//        String actual = rootNode.toString();
//        assertEquals(expectedOutput, actual);
//    }
//
//    @Test
//    public void requestURLReturnsStringCorrectly() {
//        //Temporary before test method idea
//        fail("Not implemented yet");
//    }
//
//    @Test
//    public void returnsCorrectWebsiteContentString() {
//        assertEquals(siteContent, sc.getWebsiteContent());
//    }
//
//    @Test
//    public void TagContentFromUserRequestedHtmlTagReturnedCorrectly() {
//        String[] expectedArray = {"yo who", "yo mama"};
//        ArrayList<String> actualArray = sc.getContentFromTag("p");
//
//        assertArrayEquals(expectedArray, actualArray.toArray());
//    }
//
//    @Test
//    public void IdContentFromUserRequestedHtmlIDReturnedCorrectly() {
//        String[] expectedArray = {"chIld, of CHIld."};
//        ArrayList<String> actualArray = sc.getContentFromId("header1");
//
//        assertArrayEquals(expectedArray, actualArray.toArray());
//    }
//
//    @Test
//    public void ClassContentFromUserRequestedHtmlClassReturnedCorrectly() {
//        String[] expectedArray = {"yo who", "https://www.w3schools.com/"};
//        ArrayList<String> actualArray = sc.getContentFromClass("testClass");
//
//        assertArrayEquals(expectedArray, actualArray.toArray());
//    }
//
//    @Test
//    public void returnsLinksFromSiteCorrectly() {
//        String[] expectedArray = {"https://www.w3schools.com/", "https://www.test.com/"};
//        ArrayList<String> actualArray = sc.getLinksInPage();
//
//        assertArrayEquals(expectedArray, actualArray.toArray());
//    }
//
//    @Test
//    public void returnsTrueIfSiteContainsCaseSensitiveStringFromUser() {
//        boolean expected = true;
//        boolean actual = sc.contains("Hei");
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void returnsFalseIfSiteDoesNotContainsCaseSensitiveStringFromUser() {
//        boolean expected = false;
//        boolean actual = sc.contains("sdhaesf");
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void returnsTrueIfSiteContainsStringFromUser() {
//        boolean expected = true;
//
//        //Not a single string is in full caps-lock
//        boolean actual = sc.containsCaseInSensetive("HEI");
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void returnsFalseIfSiteDoesNotConatainStringFromUser() {
//        boolean expected = false;
//        boolean actual = sc.containsCaseInSensetive("sdhaesf");
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void getsAllImagineLinksFromSite() {
//        String[] expectedArray = {"img_girl.jpg", "www.google.com/hjelp/img_boy.jpg"};
//        ArrayList<String> actualArray = sc.getAllImagesFromPage();
//
//        assertArrayEquals(expectedArray, actualArray.toArray());
//    }
//
//    @Test
//    public void getsSpecificImageByIdFromSite() {
//        String expected = "img_girl.jpg";
//        String actual = sc.getImageById("bestebildet");
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void getsSpecificImagesByClassNameFromSite() {
//        String[] expectedArray = {"img_girl.jpg", "www.google.com/hjelp/img_boy.jpg"};
//        ArrayList<String> actualArray = sc.getImageByClass("bestebildene");
//
//        assertArrayEquals(expectedArray, actualArray.toArray());
//    }
//
//    @Test
//    public void getsAllVideosFromSiteCorrectly() {
//        String[] expectedArray = {"video_girl.mp4", "www.google.com/hjelp/video_boy.wma"};
//        ArrayList<String> actualArray = sc.getAllVideosFromPage();
//
//        assertArrayEquals(expectedArray, actualArray.toArray());
//    }
//
//    @Test
//    public void getsSpecificVideoByIdFromSite() {
//        String expected = "video_girl.mp4";
//        String actual = sc.getVideoById("bestevideoen");
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void getsSpecificVideosByClassNameFromSite() {
//        String[] expectedArray = {"video_girl.mp4"};
//        ArrayList<String> actualArray = sc.getVideoByClass("bestevideoene");
//
//        assertArrayEquals(expectedArray, actualArray.toArray());
//    }
//
//    @Test
//    public void returnsAllClassesInSiteCorrectly() {
//        String[] expectedArray = {"class1", "bestebildene", "bestevideoene", "testClass"};
//        ArrayList<String> actualArray = sc.getClassesInPage();
//
//        assertArrayEquals(expectedArray, actualArray.toArray());
//    }
//
//    @Test
//    public void returnsAllIdsInSiteCorrectly() {
//        String[] expectedArray = {"hi", "bestebildet", "bestevideoen", "para", "header1"};
//        ArrayList<String> actualArray = sc.getIdsInPage();
//
//        assertArrayEquals(expectedArray, actualArray.toArray());
//    }
//}
//

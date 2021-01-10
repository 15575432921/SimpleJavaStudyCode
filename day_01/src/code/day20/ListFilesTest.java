package code.day20;

import java.io.File;

public class ListFilesTest {
   public static long L=0L;
    public static void main(String[] args) {
        File file=new File("D:\\study");

         dfs(file);
        System.out.println(L);
    }
static void dfs(File file){
        if(file.isDirectory()) {
            String[] list = file.list();
            if (!(list == null || list.length == 0)) {
                for (int i = 0; i < list.length; i++) {
                    System.out.println(list[i]);
                    File file1 = new File(file,list[i]);
                    if (file1.isDirectory()) {
                        dfs(file1);
                    }else if(file1.isFile())
                    {
                        L+=file1.length();
                    }
                }
            }
        }
        else if(file.isFile())
        {
            L+=file.length();
        }
}
}

import java.io.File;

public class IO {
    public static void main(String[] args) {
        File  file=new File("D:/QQ文件/profile/C#OOP项目ATM取款机");
        delete(file);
    }

    private static void delete(File file) {
        //判断文件是否存在
        if(file.exists()){
            //判断是否是文件夹
            if(file.isDirectory()){
                File[] files=file.listFiles();
                //判断文件夹里是否有文件
                if(files.length>=1){
                    //遍历文件夹的所有子文件
                    for (File file1:files){
                        //是文件直接删除
                        if(file1.isFile()){
                            file1.delete();
                            System.out.println("成功删除:"+file1.getAbsolutePath());
                        }else{
                            //是文件夹递归
                            delete(file1);
                        }
                    }
                    //file此时已经是空文件夹，直接删除
                    file.delete();
                    System.out.println("成功删除:"+file.getAbsolutePath());
                }else{
                    //是文件直接删除
                    file.delete();
                    System.out.println("成功删除"+file.getAbsolutePath());
                }
            }else{
                //是文件直接删除
                file.delete();
                System.out.println("成功删除"+file.getAbsolutePath());
            }
        }else{
            System.out.println("此文件不存在");
        }
    }
}

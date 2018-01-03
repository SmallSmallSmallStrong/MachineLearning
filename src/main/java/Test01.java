import jdk.nashorn.internal.runtime.URIUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Test01 {

    public static void main(String[] args) {
        //读取数据存入数组
        List Sex = new ArrayList<>();
        List Length = new ArrayList<>();
        List Diameter = new ArrayList<>();
        List Height = new ArrayList<>();
        List Whole_weight = new ArrayList<>();
        List Shucked_weight = new ArrayList<>();
        List Viscera_weight = new ArrayList<>();
        List Shell_weight = new ArrayList<>();
        List Rings = new ArrayList();
        try {
            Path path = Paths.get(Test01.class.getResource("abalone.data").toURI());
            List<String> list = Files.readAllLines(path);
            list.forEach(s -> {
                String[] strs = s.split(",");
                //简单的检测数据完整性
                if (strs.length != 9) {
                    System.out.println("no");
                }
                Sex.add(strs[0]);
                Length.add(strs[1]);
                Diameter.add(strs[2]);
                Height.add(strs[3]);
                Whole_weight.add(strs[4]);
                Shucked_weight.add(strs[5]);
                Viscera_weight.add(strs[6]);
                Shell_weight.add(strs[7]);
                Rings.add(strs[8]);
            });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        //验证数据的正确性
        //sex的数据
        if (Sex.size() >  0 ){
            Sex.forEach(System.out::println);
        }
    }
}
package sinocraft.core;

import java.io.File;
import java.util.zip.ZipFile;
import java.io.FilenameFilter;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Enumeration;

public class SCLoader {
    public static void load(File SCSourceFile) {
        Map< String, List<String>> SCLoadClassLists = new HashMap<String, List<String>>();
        if (SCSourceFile.isDirectory()) {
            try {
                SCLog.log("try open path :" + SCSourceFile + System.getProperty("file.separator") + "sinocraft" + System.getProperty("file.separator"));
                SCSourceFile = new File( SCSourceFile + System.getProperty("file.separator") + "sinocraft" + System.getProperty("file.separator"));
            } catch (Exception e) {
                SCLog.log("WARNING", "Error when open sinocraft path .");
                return;
            }
            for (File SCFile : SCSourceFile.listFiles(new SCPackageFilter())) {
                List<String> SCLoadList = new ArrayList<String>();
                for (File SCClassFile : SCFile.listFiles(
                new FilenameFilter () {
                @Override
                public boolean accept(File dir, String name) {
                        return name.endsWith(".class");
                    }
                })) {
                    SCLoadList.add("sinocraft." + SCFile.getName() + "." + SCClassFile.getName().substring(0, SCClassFile.getName().lastIndexOf(".class")));
                }
                SCLoadClassLists.put(SCFile.getName(), SCLoadList);
            }
        } else {
            try {
                SCLog.log("try open modfile :" + SCSourceFile);
                ZipFile zf = new ZipFile(SCSourceFile);
                Enumeration<?> en = zf.entries();
                while (en.hasMoreElements()) {
                    String st = en.nextElement().toString();
                    st = st.replace("/", ".");
                    for (String SCLoadPackage : SCPackageFilter.SCLoadPackageList) {
                        if (st.startsWith("sinocraft." + SCLoadPackage)) {
                            if (st.endsWith(".class")) {
                                List<String> SCLoadList = SCLoadClassLists.get(SCLoadPackage);
                                if (SCLoadList == null) {
                                    SCLoadList = new ArrayList<String>();
                                    SCLoadClassLists.put(SCLoadPackage,SCLoadList);
                                }
                                SCLoadList.add(st.substring(0, st.lastIndexOf(".class")));
                            }
                        }
                    }
                }
            } catch (Exception e) {
                SCLog.log("WARNING", "Error when open sinocraft modfile .");
                return;
            }
        }
        for (Map.Entry<String, List<String>> entry : SCLoadClassLists.entrySet()) {
            SCLog.log(entry.getKey() + ":" + entry.getValue());
        }
    }
}

class SCPackageFilter implements FilenameFilter {
    public static List<String> SCLoadPackageList = new ArrayList<String>();
    static {
        SCLoadPackageList.add("blocks");
    }

    @Override
    public  boolean accept(File dir, String name) {
        for (String st : SCLoadPackageList)
            if (name.equals(st)) return true;
        return false;
    }
}
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] files) {      
        
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String f1, String f2) {            
                
                FileInfo file1 = extractFileInfo(f1.split("[0-9]"), f1);
                FileInfo file2 = extractFileInfo(f2.split("[0-9]"), f2);
                
                int headCompare = file1.head.compareTo(file2.head);
                
                if (headCompare == 0) {
                    return file1.number.compareTo(file2.number);                  
                } else {
                    return headCompare;
                }                
            }
        });
        
        return files;
    }
    
    private FileInfo extractFileInfo(String[] fileInfo, String fileName) {
        String head = fileInfo[0].toLowerCase();     
        Integer number = extractNumber(fileName.substring(head.length()));        
        return new FileInfo(head, number);
    }
    
    private Integer extractNumber(String numStr) {
        StringBuilder number = new StringBuilder();
        for (char c : numStr.toCharArray()) {
            if (Character.isDigit(c)) {
                number.append(c);
            } else {
                return Integer.parseInt(number.toString());
            }
        }
        return Integer.parseInt(number.toString());
    }
    
}

class FileInfo {
    
    String head;
    
    Integer number;
    
    FileInfo(String head, Integer number) {
        this.head = head;
        this.number = number;        
    }
    
}
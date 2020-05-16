package com.hushunjian.folder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Folder {

    private String name;

    private String parentName;

    private String path;

    private Integer level;

    private Integer orderNum;

    private String parentFullPath;

    public String getParentPath(){
        if (!path.contains(".")){
            return "";
        }
        return path.substring(0, path.lastIndexOf("."));
    }
    
    Folder(String name) {
    	this.name = name;
    }

}

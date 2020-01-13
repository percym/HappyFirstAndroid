package zw.co.researchhub.happyfirst.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

import lombok.Data;

@Entity(tableName="general_tips")
@Data
public class GeneralTip   implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int gen_tip_id;

    @ColumnInfo(name="title")
    private String title;

    @ColumnInfo(name="content")
    private String content;

    @ColumnInfo(name ="guest_viewed")
    private Boolean viewed;

//    @Embedded(prefix = "mylist_array") private ArrayList<MyListItems> myListItems;
}


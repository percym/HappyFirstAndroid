package zw.co.researchhub.happyfirst.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName="student")
public class Student extends User implements Serializable {

    @ColumnInfo(name="teacher_id")
    private int teacher_id;

    @ColumnInfo(name="parent_id")
    private int parent_id;

    @ColumnInfo(name="is_going")
    private int isGoing;

//    @Embedded(prefix = "mylist_array") private ArrayList<MyListItems> myListItems;


    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }


}


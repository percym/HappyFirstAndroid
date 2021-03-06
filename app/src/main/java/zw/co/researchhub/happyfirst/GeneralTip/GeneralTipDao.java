package zw.co.researchhub.happyfirst.GeneralTip;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import zw.co.researchhub.happyfirst.CONSTANTS;
import zw.co.researchhub.happyfirst.model.GeneralTip;

@Dao
public interface GeneralTipDao {
    @Query("SELECT * FROM "+ CONSTANTS.GENERAL_TIPS_TABLE)
    LiveData<List<GeneralTip>> getAll();;


    /*
     * Insert the object in database
     * @param note, object to be inserted
     */
    @Insert
    void insert(GeneralTip generalTip);

    /*
     * update the object in database
     * @param note, object to be updated
     */
    @Update
    void update(GeneralTip generalTip);

    /*
     * delete the object from database
     * @param note, object to be deleted
     */
    @Delete
    void delete(GeneralTip generalTip);

    /*
     * delete list of objects from database
     * @param note, array of objects to be deleted
     */
    @Delete
    void delete(GeneralTip... generalTip);      // Note... is varargs, here note is an array


    @Query("SELECT * FROM " + CONSTANTS.GENERAL_TIPS_TABLE +  " WHERE gen_tip_id = :id")
    public GeneralTip getGeneralTipById(Long id);


    @Query("DELETE FROM " + CONSTANTS.GENERAL_TIPS_TABLE)
    void deleteAll();

}

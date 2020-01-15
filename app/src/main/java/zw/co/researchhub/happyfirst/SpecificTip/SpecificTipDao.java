package zw.co.researchhub.happyfirst.SpecificTip;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import zw.co.researchhub.happyfirst.CONSTANTS;
import zw.co.researchhub.happyfirst.model.GeneralTip;
import zw.co.researchhub.happyfirst.model.SpecificTip;

@Dao
public interface SpecificTipDao {
    @Query("SELECT * FROM "+ CONSTANTS.SPECIFIC_TIPS_TABLE)
    LiveData<List<SpecificTip>> getAll();;


    /*
     * Insert the object in database
     * @param note, object to be inserted
     */
    @Insert
    void insert(SpecificTip specificTip);

    /*
     * update the object in database
     * @param note, object to be updated
     */
    @Update
    void update(SpecificTip specificTip);

    /*
     * delete the object from database
     * @param note, object to be deleted
     */
    @Delete
    void delete(SpecificTip specificTip);

    /*
     * delete list of objects from database
     * @param note, array of objects to be deleted
     */
    @Delete
    void delete(SpecificTip... specificTip);      // Note... is varargs, here note is an array


    @Query("SELECT * FROM " + CONSTANTS.SPECIFIC_TIPS_TABLE +  " WHERE spec_tip_id = :id")
    public SpecificTip getSpecificTipById(Long id);


    @Query("DELETE FROM " + CONSTANTS.SPECIFIC_TIPS_TABLE)
    void deleteAll();

}

// DatabaseConnector.java
// Provides easy connection and creation of UserContacts database.
package com.example.clay.spherecollider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DatabaseConnector 
{
   // database name
   private static final String DATABASE_NAME = "SphereColliderLevels";
   private SQLiteDatabase database; // database object
   private DatabaseOpenHelper databaseOpenHelper; // database helper

   // public constructor for DatabaseConnector
   public DatabaseConnector(Context context)
   {
      // create a new DatabaseOpenHelper
      databaseOpenHelper = 
         new DatabaseOpenHelper(context, DATABASE_NAME, null, 1);
   } // end DatabaseConnector constructor

   // open the database connection
   public void open() throws SQLException
   {
      // create or open a database for reading/writing
      database = databaseOpenHelper.getWritableDatabase();
   } // end method open

   // close the database connection
   public void close() 
   {
      if (database != null)
         database.close(); // close the database connection
   } // end method close

   // inserts a new Level in the database
   public void insertLevel(String levelName, String levelBgImgsrc)
   {
      ContentValues newLevel = new ContentValues();
      newLevel.put("levelname", levelName);
      newLevel.put("levelbgimgsrc", levelBgImgsrc);

      open(); // open the database
      database.insert("levels", null, newLevel);
      close(); // close the database
   } // end method insertLevel


   // return a Cursor with all contact information in the database
   public Cursor getAllLevels()
   {
      return database.query("levels", new String[] {"_id", "levelname", "levelcompleted"},
         null, null, null, null, "levelname");
   } // end method getAllContacts


   // get a Cursor containing all information about the contact specified
   // by the given id
   public Cursor getOneLevel(long id)
   {
      return database.query(
         "levels", null, "_id=" + id, null, null, null, null);
   } // end method getOneLevel

   // delete the contact specified by the given String name
   public void deleteLevel(long id)
   {
      open(); // open the database
      database.delete("levels", "_id=" + id, null);
      close(); // close the database
   } // end method deleteContact

   public void insertMultiple(ArrayList<HashMap<String, String>> levelList){

       for(HashMap<String, String> levelData : levelList){
           String levelName = "";
           String levelBgImgsrc = "";

           Iterator it = levelData.entrySet().iterator();
           while (it.hasNext()) {
               Map.Entry pair = (Map.Entry)it.next();
               System.out.println(pair.getKey() + " = " + pair.getValue());
               if(pair.getKey() == "levelname"){
                   levelName = pair.getValue().toString();
               }
               if(pair.getKey() == "levelbgimgsrc"){
                   levelBgImgsrc = pair.getValue().toString();
               }
               it.remove(); // avoids a ConcurrentModificationException
           }
           insertLevel(levelName, levelBgImgsrc);
       }
   }

    public ArrayList<Cursor> getData(String Query){
        //get writable database
        SQLiteDatabase sqlDB = databaseOpenHelper.getWritableDatabase();
        String[] columns = new String[] { "message" };
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2= new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);


        try{
            String maxQuery = Query ;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);


            //add value to cursor2
            Cursor2.addRow(new Object[] { "Success" });

            alc.set(1,Cursor2);
            if (null != c && c.getCount() > 0) {


                alc.set(0,c);
                c.moveToFirst();

                return alc ;
            }
            return alc;
        } catch(SQLException sqlEx){
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+sqlEx.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        } catch(Exception ex){

            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+ex.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        }


    }

   private class DatabaseOpenHelper extends SQLiteOpenHelper
   {
      // public constructor
      public DatabaseOpenHelper(Context context, String name,
         CursorFactory factory, int version)
      {
         super(context, name, factory, version);
      } // end DatabaseOpenHelper constructor

      // creates the contacts table when the database is created
      @Override
      public void onCreate(SQLiteDatabase db)
      {
        // query to create a new table named contacts
        String createLevelTableQuery = "CREATE TABLE levels(" +
            "_id integer primary key autoincrement, " +
            "levelname TEXT, " +
            "levelbgimgsrc TEXT, " +
            "levelcompleted TEXT, " +
            "ballColor TEXT, " +
            "inflaterColor TEXT, " +
            "deflaterColor TEXT, " +
            "maxpoints integer, " +
            "onestarpoints integer, " +
            "twostarpoints integer, " +
            "threestarpoints integer, " +
            "numlives integer, " +
            "numdeflaters integer, " +
            "numinflaters integer, " +
            "inflatermaxvelocity integer, " +
            "inflaterminvelocity integer " +
        ");";

        db.execSQL(createLevelTableQuery); // execute the query
        insertLevels(db);

      } // end method onCreate

      @Override
      public void onUpgrade(SQLiteDatabase db, int oldVersion,
          int newVersion) 
      {
      } // end method onUpgrade

       public void insertLevels(SQLiteDatabase db){
           // ideally these would not be hardcoded
           ArrayList<Level> levels = new ArrayList<>();

           levels.add(new Level(
                   "Level 1", // levelName
                   "lvl1_bg", // levelBgImgsrc - background image src filename
                   "false", // levelCompleted
                   "#FF9900", // ballColor - orange
                   "#99FF00", // inflaterColor - green
                   "#CC0000", // deflaterColor - red
                   500, // maxPoints
                   100, // oneStarPoints
                   200, // twoStarPoints
                   300, // threeStarPoints
                   3, // numLives
                   2, // numDeflaters
                   4, // numInflaters
                   5, // inflaterMaxVelocity
                   2 // inflaterMinVelocity
           ));
           // Level( levelName, levelBgImgsrc, levelCompleted, ballColor, inflaterColor, deflaterColor,
           //        maxPoints, oneStarPoints, twoStarPoints, threeStarPoints, numLives, numDeflaters,
           //        numInflaters, inflaterMaxVelocity, inflaterMinVelocity )
           levels.add(new Level("Level 2", "lvl2_bg", "false", "#FF9900", "#99FF00", "#CC0000", 500, 100, 200, 300, 3, 2, 4, 5, 2 ));
           levels.add(new Level("Level 3", "lvl3_bg", "false", "#FF9900", "#99FF00", "#CC0000", 500, 100, 200, 300, 3, 2, 4, 5, 2 ));
           levels.add(new Level("Level 4", "lvl4_bg", "false", "#FF9900", "#99FF00", "#CC0000", 500, 100, 200, 300, 3, 2, 4, 5, 2 ));
           levels.add(new Level("Level 5", "lvl5_bg", "false", "#FF9900", "#99FF00", "#CC0000", 500, 100, 200, 300, 3, 2, 4, 5, 2 ));


           for(Level level : levels) {
               String createQuery = "INSERT INTO levels" +
                       "(levelname, levelbgimgsrc, levelcompleted, ballColor, inflaterColor, deflaterColor, " +
                       "maxpoints, onestarpoints, twostarpoints, threestarpoints, numlives, " +
                       "numdeflaters, numinflaters, inflatermaxvelocity, inflaterminvelocity) VALUES" +
                       " ('" +
                       level.getLevelName() + "', '" +
                       level.getLevelBgImgsrc() + "', '" +
                       level.getLevelCompleted() + "', '" +
                       level.getBallColor() + "', '" +
                       level.getInflaterColor() + "', '" +
                       level.getDeflaterColor() + "', '" +
                       level.getMaxPoints() + "', '" +
                       level.getOneStarPoints() + "', '" +
                       level.getTwoStarPoints() + "', '" +
                       level.getThreeStarPoints() + "', '" +
                       level.getNumLives() + "', '" +
                       level.getNumDeflaters() + "', '" +
                       level.getNumInflaters() + "', '" +
                       level.getInflaterMaxVelocity() + "', '" +
                       level.getInflaterMinVelocity() +
                       "');";

               db.execSQL(createQuery); // execute the query
           }
       }
   } // end class DatabaseOpenHelper
} // end class DatabaseConnector


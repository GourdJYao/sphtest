package com.yaojian.sphtest.greendao.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.yaojian.sphtest.greendao.entity.SphInfo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SPH_INFO".
*/
public class SphInfoDao extends AbstractDao<SphInfo, Long> {

    public static final String TABLENAME = "SPH_INFO";

    /**
     * Properties of entity SphInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Databaseid = new Property(0, Long.class, "databaseid", true, "_id");
        public final static Property _id = new Property(1, Integer.class, "_id", false, "server_id");
        public final static Property Volume_of_mobile_data = new Property(2, Float.class, "volume_of_mobile_data", false, "volume_of_mobile_data");
        public final static Property Quarter = new Property(3, String.class, "quarter", false, "quarter");
    }


    public SphInfoDao(DaoConfig config) {
        super(config);
    }
    
    public SphInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SPH_INFO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: databaseid
                "\"server_id\" INTEGER," + // 1: _id
                "\"volume_of_mobile_data\" REAL," + // 2: volume_of_mobile_data
                "\"quarter\" TEXT);"); // 3: quarter
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SPH_INFO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, SphInfo entity) {
        stmt.clearBindings();
 
        Long databaseid = entity.getDatabaseid();
        if (databaseid != null) {
            stmt.bindLong(1, databaseid);
        }
 
        Integer _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(2, _id);
        }
 
        Float volume_of_mobile_data = entity.getVolume_of_mobile_data();
        if (volume_of_mobile_data != null) {
            stmt.bindDouble(3, volume_of_mobile_data);
        }
 
        String quarter = entity.getQuarter();
        if (quarter != null) {
            stmt.bindString(4, quarter);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, SphInfo entity) {
        stmt.clearBindings();
 
        Long databaseid = entity.getDatabaseid();
        if (databaseid != null) {
            stmt.bindLong(1, databaseid);
        }
 
        Integer _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(2, _id);
        }
 
        Float volume_of_mobile_data = entity.getVolume_of_mobile_data();
        if (volume_of_mobile_data != null) {
            stmt.bindDouble(3, volume_of_mobile_data);
        }
 
        String quarter = entity.getQuarter();
        if (quarter != null) {
            stmt.bindString(4, quarter);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public SphInfo readEntity(Cursor cursor, int offset) {
        SphInfo entity = new SphInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // databaseid
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // _id
            cursor.isNull(offset + 2) ? null : cursor.getFloat(offset + 2), // volume_of_mobile_data
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // quarter
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, SphInfo entity, int offset) {
        entity.setDatabaseid(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.set_id(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setVolume_of_mobile_data(cursor.isNull(offset + 2) ? null : cursor.getFloat(offset + 2));
        entity.setQuarter(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(SphInfo entity, long rowId) {
        entity.setDatabaseid(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(SphInfo entity) {
        if(entity != null) {
            return entity.getDatabaseid();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(SphInfo entity) {
        return entity.getDatabaseid() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
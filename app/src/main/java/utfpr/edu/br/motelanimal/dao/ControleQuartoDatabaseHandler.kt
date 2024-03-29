package utfpr.edu.br.motelanimal.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import utfpr.edu.br.motelanimal.entidades.ControleQuarto
import utfpr.edu.br.motelanimal.entidades.Relatorio

class ControleQuartoDatabaseHandler(context: Context) : DataBaseHandler(context, "controlequarto") {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE IF NOT EXISTS controlequarto (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "quarto INTEGER NOT NULL," +
                    "responsavel INTEGER NOT NULL, " +
                    "pet INTEGER NOT NULL," +
                    "active INTEGER NOT NULL," +
                    "FOREIGN KEY (pet) REFERENCES pet(id)" +
                    ");"
        )
    }

    fun save(rel: ControleQuarto): Long {
        val registro = ContentValues()
        registro.put("quarto", rel.quarto)
        registro.put("pet", rel.pet)
        registro.put("active", rel.active)
        registro.put("responsavel", rel.responsavel)


        return super.save(registro)
    }

    fun whereActive(query: String): Cursor? {
        return super.findList( null, query)
    }

    fun update(controleQuarto: ControleQuarto): Int {
        val registro = ContentValues()
        registro.put("_id", controleQuarto._id)
        registro.put("quarto", controleQuarto.quarto)
        registro.put("pet", controleQuarto.pet)
        registro.put("responsavel", controleQuarto.responsavel)
        registro.put("active", 0)
        return super.update(registro, controleQuarto._id)
    }

}
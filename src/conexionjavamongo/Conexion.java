package conexionjavamongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aaron
 */
public class Conexion {
    DB BaseDatos;
    DBCollection coleccion;
    BasicDBObject documento = new BasicDBObject();
    
    public Conexion(){
        try {
            Mongo mongo = new Mongo("localhost",27017);
            BaseDatos = mongo.getDB("Actividad6");
            coleccion = BaseDatos.getCollection("Celulares");
            System.out.println("conexion exitosa");
        } catch (UnknownHostException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public boolean insertar(String marca){
        documento.put("Marca", marca);
        coleccion.insert(documento);
        return true;
    }
    
    public void Mostrar(){
        DBCursor cursor = coleccion.find();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }
    
    public boolean Actualizar(String marcaVieja, String marcaNueva){
        documento.put("Marca", marcaVieja);
        BasicDBObject documentoNuevo = new BasicDBObject();
        documentoNuevo.put("Marca",marcaNueva);
        coleccion.findAndModify(documento, documentoNuevo);
        return true;
    }
    
    public boolean Eliminar(String marca){
        documento.put("Marca", marca);
        coleccion.remove(documento);
        return true;
    }
}

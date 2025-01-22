package org.example;

import org.example.DB.CiclistaEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Session session=createSesion();

        getCiclistaById(session,1);
        List<CiclistaEntity> lista=getCiclistaByNameList(session);
        System.out.println(lista);

        getCiclistaTeamName(session,"Banesto");
        getCiclistaByTeamNameAndAge(session,"Banesto",30);
        getCiclistaEntityCount(session);
        getNameFromCiclista(session);

        closeSesion(session);
    }

    private static void closeSesion(Session session) {
        if (session!=null){
            session.close();
        }
        System.out.println("Session has been closed");
    }

    private static Session createSesion() {
        SessionFactory sessionFactory=
                new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();

        if (session!=null){
            System.out.println("Session initiated");
        }else{
            System.out.println("Error on creating session");
        }

        return session;
    }

    /**
     * Recuperar un registro de una tabla de un id
     * @param session
     * @param id
     */
    private static void  getCiclistaById(Session session,int id){
        System.out.println("Método getCiclistaById:");
        CiclistaEntity ciclistaEntity= (CiclistaEntity) session.get(CiclistaEntity.class,id);

        System.out.println(ciclistaEntity);
    }

    /**
     * Recuperar datos de varios registros de una tabla
     * @param session
     * @return
     */
    private static List<CiclistaEntity> getCiclistaByNameList(Session session){
        System.out.println("Método getCiclistaByNameList:");
        String nombre="Miguel";
        Query querysql=
                session.createQuery(" from CiclistaEntity where nombre like 'Miguel%'");
        List<CiclistaEntity> lista=querysql.getResultList();

        if (lista.isEmpty()){
            //throw new CiclistaNotFoundExceotion(nombre);
            System.out.println("No se ha encontrado ningñin ciclista cuyo nombre sea "+nombre);
        }

        System.out.println("Rows: "+lista.size());

        return lista;
    }

    /**
     * Recuperar datos de varios registros mediante un parámetro den HQL
     * @param session
     * @param teamName
     */
    private static void  getCiclistaTeamName(Session session,String teamName){
        System.out.println("Método getCiclistaTeamName:");
        TypedQuery<CiclistaEntity> query=
                session.createQuery("from CiclistaEntity where nomeq =:nomeq",CiclistaEntity.class); //nomeq="Miguel" es como esto
        query.setParameter("nomeq",teamName);

        List<CiclistaEntity> lista= query.getResultList();

        System.out.println(lista);
    }

    private static void  getCiclistaByTeamNameAndAge(Session session,String teamName,int age){
        System.out.println("Método getCiclistaByTeamNameAndAge:");
        String nombre="Miguel";
        Query querysql=
                session.createQuery(" from CiclistaEntity where nomeq=:nombre_equipo and edad>:edad");
        querysql.setParameter("nombre_equipo",teamName);
        querysql.setParameter("edad",age);

        List<CiclistaEntity> lista= querysql.getResultList();

        System.out.println(lista);
    }

    private static void  getCiclistaEntityCount(Session session){
        System.out.println("Método getCiclistaEntityCount:");

        Query querysql=
        session.createQuery("select count(*) from CiclistaEntity ");

        long num=(long)querysql.uniqueResult();

        System.out.println("Número de ciclistas: "+num);
    }

    private static void  getNameFromCiclista(Session session){
        System.out.println("Método getNameFromCiclista:");

        Query querysql= session.createQuery("select nombre from CiclistaEntity");

        List<CiclistaEntity> lista= querysql.getResultList();

        System.out.println(lista);
    }

}

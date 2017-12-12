package edu.itla.tripdom;

import edu.itla.tripdom.entity.Usuario;

/**
 * Created by Estarlin Velez on 10/12/17.
 */

public class UsuarioActual {
    private static Usuario usuario;

    public static Usuario getUsuario(){
        return usuario;

    }
        public static Usuario setUsuario (Usuario usuario){
        UsuarioActual.usuario = usuario;
        return UsuarioActual.usuario;
    }

    }


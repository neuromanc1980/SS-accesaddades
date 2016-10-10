package src;

import java.util.HashMap;
import java.util.*;
import java.util.stream.Collectors;

public class SeguridadSocialMap {


    private Map <String, Persona> personaMapDni = new HashMap();
    private Map <String, Persona> personaMapSS = new HashMap();

    public SeguridadSocialMap() {

        //no cal constructor
    }



// Debes comprobar que no se introduzcan dos personas con el mismo DNI/Número Seguridad Social

    public void altaPersona(Persona persona) {

        if(!personaMapDni.containsKey(persona.getDNI()) && !personaMapSS.containsKey(persona.getNumSeguridadSocial())){
            personaMapDni.put(persona.getDNI(), persona);
            personaMapSS.put(persona.getNumSeguridadSocial(), persona);
        }

    }

    public void bajaPersona(String dni) {

        if(!personaMapDni.containsKey(dni)){
            personaMapDni.remove(dni);
            personaMapSS.remove(personaMapDni.get(dni).getNumSeguridadSocial());
        }

    }

    public Persona obtenerPersonaPorDNI(String dni) {

        if (personaMapDni.containsKey(dni)){
            return personaMapDni.get(dni);
        } else return null;

    }

    public Persona obtenerPersonaPorNumSS(String numSS) {

        if (personaMapSS.containsKey(numSS)){
            return personaMapSS.get(numSS);
        } else return null;

    }

    public List<Persona> obtenerPersonasMayoresQue(int edad){

       return personaMapDni.values().stream().filter(persona -> persona.getEdad()>edad).collect(Collectors.toList());

    }

    public List<Persona> obtenerTodas(){

        List<Persona> aux = new ArrayList<>(personaMapDni.values());

       return aux;
    }

    public Persona maxSalario() {

        Persona max = null;

        for (Persona persona: personasList) {

            if (max == null) {
                max = persona;

            }else {
                if (persona.getSalario() >  max.getSalario()){
                    max = persona;
                }
            }

        } return max;

        //j8
        //return personasList.stream().max(Comparator.comparing(Persona::getSalario)).get();

    }

    public Persona minSalario() {

        Persona min = null;

        for (Persona persona: personasList) {

            if (min == null) {
                min = persona;

            }else {
                if (persona.getSalario() <  min.getSalario()){
                    min = persona;
                }
            }

        } return min;

        //j8
        //return personasList.stream().max(Comparator.comparing(Persona::getSalario)).get();

    }

    @Override

    public String toString() {

        return "SeguridadSocial{" +

                "personasList=" + personasList +

                '}';

    }

}


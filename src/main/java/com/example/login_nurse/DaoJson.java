package com.example.login_nurse;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DaoJson  {
	
	public ArrayList<Nurse> readFile() throws IllegalArgumentException, IOException {
		
		InputStream filePath = getClass().getResourceAsStream("/nurse_list.json");
	
		ObjectMapper mapper = new ObjectMapper();
        // Leer el archivo json
        JsonNode root = mapper.readTree(filePath);
        // Obtener el array nurse_list.json
        JsonNode nurseArray = root.get("nurse_list");
        // Creo una lista y le assigno el contenido del json
        List<Nurse> nursesList = Arrays.asList(mapper.treeToValue(nurseArray, Nurse[].class));

        return new ArrayList<>(nursesList);
	     
		
		
		
	}

}
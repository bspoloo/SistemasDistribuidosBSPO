/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.java.classes;

/**
 *
 * @author Animetx
 */
public class JSON {

    private String dataJSON;

    public JSON(String dataJSON) {
        this.dataJSON = dataJSON;
    }

    public <T> T getDataType(String data) {
        try {
            String[] parts = this.dataJSON.split("\"" + data + "\":\"");
            if (parts.length > 1) {
                String value = parts[1].split("\"")[0];
                return (T) value;
            }

            parts = this.dataJSON.split("\"" + data + "\":");
            if (parts.length > 1) {
                String value = parts[1].split(",|}")[0].trim();
                if (Integer.class.isAssignableFrom(getClassType())) {
                    return (T) Integer.valueOf(value);
                }
                if (Long.class.isAssignableFrom(getClassType())) {
                    return (T) Long.valueOf(value);
                }
                return (T) value;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Class<?> getClassType() {
        return Object.class;
    }

    public String getDataJSON() {
        return dataJSON;
    }

    public void setDataJSON(String dataJSON) {
        this.dataJSON = dataJSON;
    }

}

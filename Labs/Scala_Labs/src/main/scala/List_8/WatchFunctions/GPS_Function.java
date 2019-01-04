package List_8.WatchFunctions;

import java.text.DecimalFormat;

public class GPS_Function extends Function {

    private double latitude = Math.random() * 180;
    private double longitude = Math.random() * 90;

    @Override
    void setDetails() {
        System.out.println("Do you want to update?");
        boolean jakiśStan = false;
        if(jakiśStan){
            double difference = (Math.random() - 2)*2;
            latitude += difference;
            longitude += difference;
        } else {

        }
    }

    @Override
    String checkState() {
        DecimalFormat latD = new DecimalFormat("###.######");
        DecimalFormat lonD = new DecimalFormat("##.######");

        return "Latitude: " + latD.format(latitude) + " Longitude: " + lonD.format(longitude);
    }
}

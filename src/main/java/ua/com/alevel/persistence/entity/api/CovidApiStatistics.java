package ua.com.alevel.persistence.entity.api;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.HashMap;

@Entity
@Table(name = "covid_api_statistics_table")
public class CovidApiStatistics {

    @Id
    private Long id;
    private String date;
    private String last_update;
    private String confirmed;
    private String confirmed_diff;
    private String deaths;
    private String deaths_diff;
    private String recovered;
    private String recovered_diff;
    private String active;
    private String active_diff;
    private String fatality_rate;

    public CovidApiStatistics() {
        this.id = 1L;
    }

    public void setData(HashMap<String, String> data) {
        this.date = data.get("date");
        this.last_update = data.get("last_update");
        this.confirmed = data.get("confirmed");
        this.confirmed_diff = data.get("confirmed_diff");
        this.deaths = data.get("deaths");
        this.deaths_diff = data.get("deaths_diff");
        this.recovered = data.get("recovered");
        this.recovered_diff = data.get("recovered_diff");
        this.active = data.get("active");
        this.active_diff = data.get("active_diff");
        this.fatality_rate = data.get("fatality_rate");
    }

    public HashMap<String, String> getData() {
        HashMap<String, String> data = new HashMap<>();
        data.put("date", date);
        data.put("last_update", last_update);
        data.put("confirmed", confirmed);
        data.put("confirmed_diff", confirmed_diff);
        data.put("deaths", deaths);
        data.put("deaths_diff", deaths_diff);
        data.put("recovered", recovered);
        data.put("recovered_diff", recovered_diff);
        data.put("active", active);
        data.put("active_diff", active_diff);
        data.put("fatality_rate", fatality_rate);
        return data;
    }
}

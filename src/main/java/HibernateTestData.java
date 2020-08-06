import com.sun.istack.NotNull;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author kehul on 06.08.2020
 */
@Entity(name = "hibernate_test_data")
public class HibernateTestData {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private String caption;
	
	public void setId(@NotNull Integer value) {
		id = value;
	}
	
	public void setName(String value) {
		name = value;
	}
	
	public void setCaption(String value) {
		caption = value;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCaption() {
		return caption;
	}
}

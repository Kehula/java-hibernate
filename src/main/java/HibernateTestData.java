import com.sun.istack.NotNull;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author kehul on 06.08.2020
 */
@Entity
public class HibernateTestData {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private String caption;
	
	//@Setter(name = "ID")
	public void setId(@NotNull Integer value) {
		id = value;
	}
	
	//@Setter(name = "NAME")
	public void setName(String value) {
		name = value;
	}
	
	//@Setter(name = "CAPTION")
	public void setCaption(String value) {
		caption = value;
	}
	
	//@Getter(name = "ID")
	public Integer getId() {
		return id;
	}
	
	//@Getter(name = "NAME")
	public String getName() {
		return name;
	}
	
	//@Getter(name = "CAPTION")
	public String getCaption() {
		return caption;
	}
}

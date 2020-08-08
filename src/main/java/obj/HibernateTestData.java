package obj;

import com.sun.istack.NotNull;
import javax.persistence.*;

/**
 * @author kehul on 06.08.2020
 */
@Entity
@Table(name = "hibernate_test_data")
public class HibernateTestData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "CAPTION")
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

package templates;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Container {
	@Id
	@Column(name="id_container")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	public String type;
	public String msg;
}

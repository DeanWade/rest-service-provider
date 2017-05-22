package hello.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Greeting implements Serializable{

	private static final long serialVersionUID = -3254983270496479171L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    private String content;
    
    public Greeting() {
    }
    
    public Greeting(String content) {
        this.content = content;
    }

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
    
	@Override
	public String toString() {
		return "Greeting [id=" + id + ", content=" + content + "]";
	}
}

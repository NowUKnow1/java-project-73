package hexlet.code.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

import static javax.persistence.TemporalType.TIMESTAMP;

@Entity
@Table(name = "labels")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Label Name should not be empty")
    @Column(name = "name")
    private String name;

    @CreationTimestamp
    @Temporal(TIMESTAMP)
    @Column(name = "createdAt")
    private Date createdAt;

    @JsonIgnore
    @ManyToMany(mappedBy = "labels")
    private List<Task> tasks;
}

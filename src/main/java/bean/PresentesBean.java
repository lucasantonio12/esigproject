package bean;

import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@ManagedBean(name = "presente", eager = true)
@Named
@ViewScoped
@Data
public class PresentesBean {
}

package model.dao;

public class PeoBean {
	private Integer town_id;
	private String town_name;
	private Integer h_num;
	private Integer p_num;
	private Integer m_num;
	private Integer f_num;
	private Integer info_time;

	public PeoBean(int town_id, String town_name, int h_num, int p_num, int m_num, int f_num, int info_time) {
		super();
		this.town_id = town_id;
		this.town_name = town_name;
		this.h_num = h_num;
		this.p_num = p_num;
		this.m_num = m_num;
		this.f_num = f_num;
		this.info_time = info_time;

	}

	@Override
	public String toString() {
		return "PeoBean [town_id=" + town_id + ", town_name=" + town_name + ", h_num=" + h_num + ", p_num=" + p_num
				+ ", m_num=" + m_num + ", f_num=" + f_num + ", info_time=" + info_time + "]";
	}

	public PeoBean() {

	}

	public int getTown_id() {
		return town_id;
	}

	public void setTown_id(int town_id) {
		this.town_id = town_id;
	}

	public String getTown_name() {
		return town_name;
	}

	public void setTown_name(String town_name) {
		this.town_name = town_name;
	}

	public Integer getH_num() {
		return h_num;
	}

	public void setH_num(Integer h_num) {
		this.h_num = h_num;
	}

	public Integer getP_num() {
		return p_num;
	}

	public void setP_num(Integer p_num) {
		this.p_num = p_num;
	}

	public Integer getM_num() {
		return m_num;
	}

	public void setM_num(Integer m_num) {
		this.m_num = m_num;
	}

	public Integer getF_num() {
		return f_num;
	}

	public void setF_num(Integer f_num) {
		this.f_num = f_num;
	}

	public Integer getInfo_time() {
		return info_time;
	}

	public void setInfo_time(Integer info_time) {
		this.info_time = info_time;
	}

}

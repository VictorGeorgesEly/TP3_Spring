package isep.web.sakila.webapi.model;

public class IdsWO extends WebObject {

	private static final long serialVersionUID = 4458969474190188329L;

	private int customerId;
	private int filmId;

	public IdsWO(){
    
  }

	public IdsWO(int cid, int fid) {
		this.customerId= cid;
		this.filmId = fid;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

}

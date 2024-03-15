package in.co.rays.testproject;

public class TestPayment {
	
	public static void main(String[] args) throws Exception {
		//testAdd();
		testUpdate();
		//testDelete();
	  // testfindByPk();
			
	}

	private static void testAdd() throws Exception {
	
	PaymentBean bean = new PaymentBean();
	
	bean.setId(1);
	bean.setName("Arkaja");
	bean.setAmount(1000);
	bean.setPaymentmethod("cash");
	bean.setStatus("completed");
	bean.setPayer("paridhi");
	
	PaymentModel model = new PaymentModel();
	model.add(bean);
	
	}
	
	private static void testUpdate() throws Exception {
		
	PaymentBean bean = new PaymentBean();
	
	bean.setId(1);
	bean.setName("joshi");
	bean.setAmount(2000);
    bean.setPaymentmethod("credit");
    bean.setStatus("pending");
    bean.setPayer("gupta");
    
    PaymentModel model = new PaymentModel();
    model.update(bean);
    
    
    
	}
	
	private static void testDelete() throws Exception {
		
	PaymentModel model = new PaymentModel();
	model.delete(1);
	}
	
	private static void testfindByPk() throws Exception {
		PaymentModel model = new PaymentModel();
		PaymentBean bean = model.findbyPk();
		
		bean.setId(2);
	}
	}

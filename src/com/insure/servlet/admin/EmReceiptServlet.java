package com.insure.servlet.admin;
/*
	<servlet>
		<servlet-name>emReceipt</servlet-name>
		<servlet-class>com.insure.servlet.admin.EmReceiptServlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>emReceipt</servlet-name>
		<url-pattern>/emReceipt.do</url-pattern>
	</servlet-mapping>

 */
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.db.DbUtils;
import com.web.util.*;

public class EmReceiptServlet extends UserSecureDispatcher {

	private static final long serialVersionUID = 1492585073055L;
	
	public void blank(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	if(checkAuthority("auth44", request, response)) {
    		return;
    	}
		String uf_parentid = Putil.getString(request.getParameter("uf_parentid")) ;
		request.setAttribute("uf_parentid", uf_parentid);

		String keyword = Putil.getString(request.getParameter("keyword")) ;
		int s = Putil.getInt(request.getParameter("s")); 
		int m = Putil.getInt(request.getParameter("m")); 
		request.setAttribute("keyword", keyword);
		request.setAttribute("m", m+"");
		request.setAttribute("s", s+"");

		forward(request, response, "/admin/ReceiptAdd.jsp");
	
	}

	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(checkAuthority("auth44", request, response)) {
    		return;
    	}
		String uf_parentid = Putil.getString(request.getParameter("uf_parentid")) ;
		request.setAttribute("uf_parentid", uf_parentid);

		String keyword = Putil.getString(request.getParameter("keyword")) ;
		int s = Putil.getInt(request.getParameter("s")); 
		int m = Putil.getInt(request.getParameter("m")); 
		request.setAttribute("keyword", keyword);
		request.setAttribute("m", m+"");
		request.setAttribute("s", s+"");

		Map<String, Object> admin = LoginManager.getUser(request);
		if(admin==null) {
			return ;
		}
		
		int receiptID = 0;
		try {
			int claimid = Putil.getInt(request.getParameter("claimid"));
			int receiptno = Putil.getInt(request.getParameter("receiptno"));
			int insuredno = Putil.getInt(request.getParameter("insuredno"));
			int receipttype = Putil.getInt(request.getParameter("receipttype"));
			String receiptnumber = Putil.getString(request.getParameter("receiptnumber"));
			int hospitalid = Putil.getInt(request.getParameter("hospitalid"));
			int feetype = Putil.getInt(request.getParameter("feetype"));
			String visitdate = Putil.getString(request.getParameter("visitdate"));
			String hospitaldate = Putil.getString(request.getParameter("hospitaldate"));
			String dischargedate = Putil.getString(request.getParameter("dischargedate"));
			String claimdate = Putil.getString(request.getParameter("claimdate"));
			int medicaltype = Putil.getInt(request.getParameter("medicaltype"));
			String area = Putil.getString(request.getParameter("area"));
			float fundpaid = Putil.getFloat(request.getParameter("fundpaid"));
			float cashpaid = Putil.getFloat(request.getParameter("cashpaid"));
			float total = Putil.getFloat(request.getParameter("total"));
			int feeid = Putil.getInt(request.getParameter("feeid"));
			float fee = Putil.getFloat(request.getParameter("fee"));
			String zfmark = Putil.getString(request.getParameter("zfmark"));
			float zfamount = Putil.getFloat(request.getParameter("zfamount"));
			String bfzfmark = Putil.getString(request.getParameter("bfzfmark"));
			float bfzfamount = Putil.getFloat(request.getParameter("bfzfamount"));
			String ybbzfmark = Putil.getString(request.getParameter("ybbzfmark"));
			float ybbzfamount = Putil.getFloat(request.getParameter("ybbzfamount"));
			String ybzfmark = Putil.getString(request.getParameter("ybzfmark"));
			float ybzfamount = Putil.getFloat(request.getParameter("ybzfamount"));
			float mentalillnessamount = Putil.getFloat(request.getParameter("mentalillnessamount"));
			float dentistryamount = Putil.getFloat(request.getParameter("dentistryamount"));
			float rehabilitationamount = Putil.getFloat(request.getParameter("rehabilitationamount"));






			
			StringBuilder select = new StringBuilder("insert into em_receipt (claimid,receiptno,insuredno,receipttype,receiptnumber,hospitalid,feetype,visitdate,hospitaldate,dischargedate,claimdate,medicaltype,area,fundpaid,cashpaid,total,feeid,fee,zfmark,zfamount,bfzfmark,bfzfamount,ybbzfmark,ybbzfamount,ybzfmark,ybzfamount,mentalillnessamount,dentistryamount,rehabilitationamount) values ("
				+ "" + claimid + ""
				+ "," + receiptno + ""
				+ "," + insuredno + ""
				+ "," + receipttype + ""
				+ ",'" + receiptnumber.replace("'", "''") + "'"
				+ "," + hospitalid + ""
				+ "," + feetype + ""
				+ ",'" + visitdate.replace("'", "''") + "'"
				+ ",'" + hospitaldate.replace("'", "''") + "'"
				+ ",'" + dischargedate.replace("'", "''") + "'"
				+ ",'" + claimdate.replace("'", "''") + "'"
				+ "," + medicaltype + ""
				+ ",'" + area.replace("'", "''") + "'"
				+ "," + fundpaid + ""
				+ "," + cashpaid + ""
				+ "," + total + ""
				+ "," + feeid + ""
				+ "," + fee + ""
				+ ",'" + zfmark.replace("'", "''") + "'"
				+ "," + zfamount + ""
				+ ",'" + bfzfmark.replace("'", "''") + "'"
				+ "," + bfzfamount + ""
				+ ",'" + ybbzfmark.replace("'", "''") + "'"
				+ "," + ybbzfamount + ""
				+ ",'" + ybzfmark.replace("'", "''") + "'"
				+ "," + ybzfamount + ""
				+ "," + mentalillnessamount + ""
				+ "," + dentistryamount + ""
				+ "," + rehabilitationamount + ""
				+ ")"
			);

			receiptID = DbUtils.save1(select.toString());
	
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		
		if(receiptID == 0){
			prompt(response, "发票保存失败");
			return;
		}
		
		try {
			float jpamount = Putil.getFloat(request.getParameter("claimsettlement.jpamount"));
			float pfrate = Putil.getFloat(request.getParameter("claimsettlement.pfrate"));
			float yyfpfje = Putil.getFloat(request.getParameter("claimsettlement.yyfpfje"));
			String jcfpfje = Putil.getString(request.getParameter("claimsettlement.jcfpfje"));
			float cwfpfje = Putil.getFloat(request.getParameter("claimsettlement.cwfpfje"));
			float pfamount = Putil.getFloat(request.getParameter("claimsettlement.pfamount"));
			String yyfremark = Putil.getString(request.getParameter("claimsettlement.yyfremark"));


			
			StringBuilder select = new StringBuilder("insert into em_claimsettlement (receiptid,jpamount,pfrate,yyfpfje,jcfpfje,cwfpfje,pfamount,yyfremark) values ("
				+ "" + receiptID + ""
				+ "," + jpamount + ""
				+ "," + pfrate + ""
				+ "," + yyfpfje + ""
				+ ",'" + jcfpfje.replace("'", "''") + "'"
				+ "," + cwfpfje + ""
				+ "," + pfamount + ""
				+ ",'" + yyfremark.replace("'", "''") + "'"
				+ ")"
			);

			int result = DbUtils.save(select.toString());
	
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

		redirect(request, response, "/emReceipt.do?method=list&uf_parentid="+uf_parentid+"&keyword="+keyword+"&m="+m+"&s="+s);
		
	}

	public void fill(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uf_parentid = Putil.getString(request.getParameter("uf_parentid")) ;
		request.setAttribute("uf_parentid", uf_parentid);

		String keyword = Putil.getString(request.getParameter("keyword")) ;
		int s = Putil.getInt(request.getParameter("s")); 
		int m = Putil.getInt(request.getParameter("m")); 
		request.setAttribute("keyword", keyword);
		request.setAttribute("m", m+"");
		request.setAttribute("s", s+"");

		String id = Putil.getString(request.getParameter("id")) ;
		if(id.length()>0) {
			Map<String, Object> row = DbUtils.queryOne("select p.* from em_receipt p where p.id="+id);
			request.setAttribute("item", row);
		}

		forward(request, response, "/admin/ReceiptEdit.jsp");
		
	}

	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(checkAuthority("auth44", request, response)) {
    		return;
    	}
		String uf_parentid = Putil.getString(request.getParameter("uf_parentid")) ;
		request.setAttribute("uf_parentid", uf_parentid);

		String keyword = Putil.getString(request.getParameter("keyword")) ;
		int s = Putil.getInt(request.getParameter("s")); 
		int m = Putil.getInt(request.getParameter("m")); 
		request.setAttribute("keyword", keyword);
		request.setAttribute("m", m+"");
		request.setAttribute("s", s+"");

		int claimid = Putil.getInt(request.getParameter("claimid"));
		try {
			String id = Putil.getString(request.getParameter("id")) ;
			int receiptno = Putil.getInt(request.getParameter("receiptno"));
			int insuredno = Putil.getInt(request.getParameter("insuredno"));
			int receipttype = Putil.getInt(request.getParameter("receipttype"));
			String receiptnumber = Putil.getString(request.getParameter("receiptnumber"));
			int hospitalid = Putil.getInt(request.getParameter("hospitalid"));
			int feetype = Putil.getInt(request.getParameter("feetype"));
			String visitdate = Putil.getString(request.getParameter("visitdate"));
			String hospitaldate = Putil.getString(request.getParameter("hospitaldate"));
			String dischargedate = Putil.getString(request.getParameter("dischargedate"));
			String claimdate = Putil.getString(request.getParameter("claimdate"));
			int medicaltype = Putil.getInt(request.getParameter("medicaltype"));
			String area = Putil.getString(request.getParameter("area"));
			float fundpaid = Putil.getFloat(request.getParameter("fundpaid"));
			float cashpaid = Putil.getFloat(request.getParameter("cashpaid"));
			float total = Putil.getFloat(request.getParameter("total"));
			int feeid = Putil.getInt(request.getParameter("feeid"));
			float fee = Putil.getFloat(request.getParameter("fee"));
			String zfmark = Putil.getString(request.getParameter("zfmark"));
			float zfamount = Putil.getFloat(request.getParameter("zfamount"));
			String bfzfmark = Putil.getString(request.getParameter("bfzfmark"));
			float bfzfamount = Putil.getFloat(request.getParameter("bfzfamount"));
			String ybbzfmark = Putil.getString(request.getParameter("ybbzfmark"));
			float ybbzfamount = Putil.getFloat(request.getParameter("ybbzfamount"));
			String ybzfmark = Putil.getString(request.getParameter("ybzfmark"));
			float ybzfamount = Putil.getFloat(request.getParameter("ybzfamount"));
			float mentalillnessamount = Putil.getFloat(request.getParameter("mentalillnessamount"));
			float dentistryamount = Putil.getFloat(request.getParameter("dentistryamount"));
			float rehabilitationamount = Putil.getFloat(request.getParameter("rehabilitationamount"));




			
			StringBuilder select = new StringBuilder("update em_receipt set "
					+ "claimid=" + claimid + ""
					+ ",receiptno=" + receiptno + ""
					+ ",insuredno=" + insuredno + ""
					+ ",receipttype=" + receipttype + ""
					+ ",receiptnumber='" + receiptnumber.replace("'", "''") + "'"
					+ ",hospitalid=" + hospitalid + ""
					+ ",feetype=" + feetype + ""
					+ ",visitdate='" + visitdate.replace("'", "''") + "'"
					+ ",hospitaldate='" + hospitaldate.replace("'", "''") + "'"
					+ ",dischargedate='" + dischargedate.replace("'", "''") + "'"
					+ ",claimdate='" + claimdate.replace("'", "''") + "'"
					+ ",medicaltype=" + medicaltype + ""
					+ ",area='" + area.replace("'", "''") + "'"
					+ ",fundpaid=" + fundpaid + ""
					+ ",cashpaid=" + cashpaid + ""
					+ ",total=" + total + ""
					+ ",feeid=" + feeid + ""
					+ ",fee=" + fee + ""
					+ ",zfmark='" + zfmark.replace("'", "''") + "'"
					+ ",zfamount=" + zfamount + ""
					+ ",bfzfmark='" + bfzfmark.replace("'", "''") + "'"
					+ ",bfzfamount=" + bfzfamount + ""
					+ ",ybbzfmark='" + ybbzfmark.replace("'", "''") + "'"
					+ ",ybbzfamount=" + ybbzfamount + ""
					+ ",ybzfmark='" + ybzfmark.replace("'", "''") + "'"
					+ ",ybzfamount=" + ybzfamount + ""
					+ ",mentalillnessamount=" + mentalillnessamount + ""
					+ ",dentistryamount=" + dentistryamount + ""
					+ ",rehabilitationamount=" + rehabilitationamount + ""
				+ " where id=" + id + "" 
			);
			int result = DbUtils.save(select.toString());

		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
		}

		redirect(request, response, "/emReceipt.do?method=list&uf_parentid="+uf_parentid+"&keyword="+keyword+"&m="+m+"&s="+s+"&claimid="+claimid);
		
	}

	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uf_parentid = Putil.getString(request.getParameter("uf_parentid")) ;
		request.setAttribute("uf_parentid", uf_parentid);

		try {
			long totalCount = 0 ;
			String keyword = Putil.getString(request.getParameter("keyword")) ;
			int s = Putil.getInt(request.getParameter("s")); 
			int m = Putil.getInt(request.getParameter("m")); 
			String o = Putil.getString(request.getParameter("o")); // 排序字
			String sort = Putil.getString(request.getParameter("sort")); // 顺序
			String claimid = Putil.getString(request.getParameter("claimid")) ;
			

			// 列表
			if(s==0) s = 1 ;  //pagenum
			if(m==0) m = 15 ;
			List<Map<String, Object>> resultRows = new ArrayList<Map<String, Object>>();

			StringBuilder countSql = new StringBuilder("select count(p.id) as total from em_receipt p where p.id>=0"
					+ (keyword.length()>0?" and p.receiptname like '%" + keyword + "%'":"")
					+ (claimid.length()>0?" and p.claimid = " + claimid : "")
					);
			Map<String, Object> countMap = DbUtils.queryOne(countSql.toString());
			if (countMap!=null) {
				totalCount = Putil.getInt(countMap.get("total"));
			}
			
			// 列表分页语句
			resultRows = DbUtils.query("select p.* from em_receipt p where p.id>=0"
					+ (keyword.length()>0?" and p.receiptname like '%" + keyword + "%'":"")
					+ (claimid.length()>0?" and p.claimid = " + claimid : "")
					+ " order by p.id desc limit " + (s-1)*m + "," + m + ""
				);
			
			
			request.setAttribute("totalRow", totalCount);
			request.setAttribute("resultRows", resultRows);
			request.setAttribute("keyword", keyword);
			request.setAttribute("m", m+"");
			request.setAttribute("s", s+"");

			request.setAttribute("receipttypeMap", receipttypeMap);
			request.setAttribute("feetypeMap", feetypeMap);
			request.setAttribute("medicaltypeMap", medicaltypeMap);
			request.setAttribute("areaMap", areaMap);

		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
		}

		forward(request, response, "/admin/ReceiptList.jsp");
		
	}

	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(checkAuthority("auth44", request, response)) {
    		return;
    	}
		String uf_parentid = Putil.getString(request.getParameter("uf_parentid")) ;
		request.setAttribute("uf_parentid", uf_parentid);

		String keyword = Putil.getString(request.getParameter("keyword")) ;
		int s = Putil.getInt(request.getParameter("s")); 
		int m = Putil.getInt(request.getParameter("m")); 
		request.setAttribute("keyword", keyword);
		request.setAttribute("m", m+"");
		request.setAttribute("s", s+"");

		try {
			String id = Putil.getString(request.getParameter("id"));

			StringBuilder select = new StringBuilder("delete from em_receipt "
					+ " where id=" + id + "" 
					);

			int result = DbUtils.save(select.toString());

		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

		redirect(request, response, "/emReceipt.do?method=list&uf_parentid="+uf_parentid+"&keyword="+keyword+"&m="+m+"&s="+s);
		
	}
	
    public boolean checkAuthority(HttpServletRequest request, HttpServletResponse response) {
    	String auth43 = checkAuthority(43, request)!=null?"1":"";
    	String auth44 = checkAuthority(44, request)!=null?"1":"";
		request.setAttribute("auth43", auth43);
		request.setAttribute("auth44", auth44);
    	if(auth43.equals("") && auth44.equals("")) {
    		this.prompt(response, "没有权限，请联系管理员！");
    		return false;
    	}
    	return true;
    	
    }
    
    static HashMap<String, String> receipttypeMap = new HashMap<>();
    static HashMap<String, String> feetypeMap = new HashMap<>();
    static HashMap<String, String> medicaltypeMap = new HashMap<>();
    static HashMap<String, String> areaMap = new HashMap<>();
    static{
    	receipttypeMap.put("1", "门诊");
    	receipttypeMap.put("2", "住院");
    	receipttypeMap.put("3", "社保分割单");
    	
    	feetypeMap.put("11", "门诊社保分割单");
    	feetypeMap.put("12", "住院社保分割单");
    	
    	medicaltypeMap.put("1", "住院");
    	medicaltypeMap.put("2", "急诊留观");
    	medicaltypeMap.put("3", " 特殊病");

    	areaMap.put("A", "区域一:全球");
    	areaMap.put("B", "区域二:除美国、加拿大以外的国家和地区");
    	areaMap.put("C", "区域三:中国大陆（港、澳、台除外）及港、澳、台地区");
    	areaMap.put("D", "区域四:中国大陆（港、澳、台地区除外）");
    	areaMap.put("E", "区域五:投保人与本公司约定的其它就诊区域");
    	areaMap.put("F", "区域六:中国大陆及被保人国籍所在地");
    }
}


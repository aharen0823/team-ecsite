package jp.co.internous.team2404.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.team2404.model.domain.MstCategory;
import jp.co.internous.team2404.model.domain.MstProduct;
import jp.co.internous.team2404.model.form.SearchForm;
import jp.co.internous.team2404.model.mapper.MstCategoryMapper;
import jp.co.internous.team2404.model.mapper.MstProductMapper;
import jp.co.internous.team2404.model.session.LoginSession;

/**
 * 商品検索に関する処理を行うコントローラー
 * @author インターノウス
 *
 */
@Controller
@RequestMapping("/team2404")
public class IndexController {
	/*
	 * フィールド定義
	 */
	@Autowired
	private LoginSession loginSession;
	@Autowired
	private MstProductMapper productMapper;
	@Autowired
	private MstCategoryMapper categoryMapper;

	/**
	 * トップページを初期表示する。
	 * @param m 画面表示用オブジェクト
	 * @return トップページ
	 */
	@RequestMapping("/")
	public String index(Model m) {

		if (loginSession.getLogined() == false && loginSession.getTmpUserId() == 0) {
			Random randam = new Random();
			int min = -999999999;
			int max = -000000000;
			int num = min + randam.nextInt(max - min - 1);
			loginSession.setTmpUserId(num);
		}
		List<MstCategory> categories = categoryMapper.find();
		List<MstProduct> products = productMapper.find();

		m.addAttribute("categories", categories);
		m.addAttribute("selected", 0);
		m.addAttribute("products", products);
		m.addAttribute("loginSession", loginSession);
		return "index";
	}

	/**
	 * 検索処理を行う
	 * @param f 検索用フォーム
	 * @param m 画面表示用オブジェクト
	 * @return トップページ
	 */
	@RequestMapping("/searchItem")
	public String searchItem(SearchForm f, Model m) {
		List<MstProduct> products = null;
		String keywords = f.getKeywords().replaceAll("　", " ").replaceAll("\\s{2,}", " ").trim();
		String[] keywordsArray = keywords.split(" ");

		if (f.getCategory() == 0) {
			products = productMapper.findByProductName(keywordsArray);
		} else {
			products = productMapper.findByCategoryAndProductName(f.getCategory(), keywordsArray);
		}
		List<MstCategory> categories = categoryMapper.find();

		m.addAttribute("keywords", keywords);
		m.addAttribute("selected", f.getCategory());
		m.addAttribute("categories", categories);
		m.addAttribute("products", products);
		m.addAttribute("loginSession", loginSession);
		return "index";
	}

}
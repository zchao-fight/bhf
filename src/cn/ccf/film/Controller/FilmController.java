package cn.ccf.film.Controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.ccf.constants.DetailType;
import cn.ccf.mapper.FilmCategoryMapper;
import cn.ccf.mapper.FilmMapper;
import cn.ccf.pojo.Film;
import cn.ccf.pojo.FilmCategory;
import cn.ccf.pojo.FilmCategoryExample;
import cn.ccf.pojo.FilmExample;
import cn.ccf.pojo.NewsExample;

@Controller
public class FilmController {
	private static final String IMG_PATH = "/upload/temp/img/";
	private static final String VIRTUAL_IMG_PATH = "d:" + IMG_PATH;
	private static final String FILM_PATH = "/upload/temp/film/";
	private static final String VIRTUAL_FILM_PATH = "d:/" + FILM_PATH;

	@Autowired
	private FilmMapper filmMapper;
	@Autowired
	private FilmCategoryMapper filmCategoryMapper;

	@RequestMapping("searchFilm")
	public String searchFilm(HttpServletRequest req, String keyword,
			Integer page) {

		String keyString = likeKeyword(keyword);
		
		FilmExample filmExample = new FilmExample();
		FilmExample.Criteria criteria = filmExample.createCriteria();
		criteria.andTitleLike(keyString);

		page = page == null ? 1 : page;
		PageHelper.startPage(page, 12);
		List<Film> film = filmMapper.selectByExample(filmExample);
		req.setAttribute("data", new PageInfo<Film>(film));

		FilmCategoryExample filmCategoryExample = new FilmCategoryExample();

		List<FilmCategory> filmCategory = filmCategoryMapper
				.selectByExample(filmCategoryExample);
		
		Boolean flag = CollectionUtils.isEmpty(film);
		req.setAttribute("flag", flag);
		
		req.setAttribute("filmCategory", filmCategory);
		req.setAttribute("keyword", keyword);
		return "film/searchFilm";
	}
	
	private String likeKeyword(String keyword) {
		
		return "%"+keyword+"%";
	}

	@RequestMapping("modifyFilm")
	public String modifyFilm(HttpServletRequest req, Integer id) {

		Film film = filmMapper.selectByPrimaryKey(id);
		req.setAttribute("film", film);

		FilmCategoryExample filmCategoryExample = new FilmCategoryExample();

		List<FilmCategory> filmCategory = filmCategoryMapper
				.selectByExample(filmCategoryExample);
		req.setAttribute("filmCategory", filmCategory);

		return "film/modifyFilm";
	}

	@RequestMapping("showAllFilms.do")
	public String showAllFilm(HttpServletRequest req, Integer page) {

		FilmExample filmExample = new FilmExample();
		filmExample.setOrderByClause("createtime desc");

		page = page == null ? 1 : page;
		PageHelper.startPage(page, 12);

		List<Film> film = filmMapper.selectByExample(filmExample);
		req.setAttribute("data", new PageInfo<Film>(film));

		FilmCategoryExample filmCategoryExample = new FilmCategoryExample();

		List<FilmCategory> filmCategory = filmCategoryMapper
				.selectByExample(filmCategoryExample);
		req.setAttribute("filmCategory", filmCategory);

		return "film/index";
	}

	@RequestMapping("playFilm")
	public String playFilm(HttpServletRequest req, String url, Integer id)
			throws UnsupportedEncodingException {

		Film film = filmMapper.selectByPrimaryKey(id);

		/*
		 * req.setAttribute("filmurl", url); String name = new
		 * String(title.getBytes("iso8859-1"), "utf-8");
		 * req.setAttribute("title", name);
		 */

		req.setAttribute("film", film);
		//return "/film/playFilm";
		return "/film/playFilmByPlayer";
	}

	@RequestMapping("showCategoryFilm")
	public String showCategoryFilm(HttpServletRequest req, String type,
			Integer page, Integer id) {
		/*
		 * String category = ""; try { category = new
		 * String(type.getBytes("iso-8859-1"),"utf-8"); } catch
		 * (UnsupportedEncodingException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		FilmCategory filmCategory = filmCategoryMapper.selectByPrimaryKey(id);

		page = page == null ? 1 : page;
		PageHelper.startPage(page, 12);
		List<Film> film = filmMapper.selectByType(filmCategory.getTitle());
		req.setAttribute("data", new PageInfo<Film>(film));

		FilmCategoryExample filmCategoryExample = new FilmCategoryExample();

		List<FilmCategory> filmCategory1 = filmCategoryMapper
				.selectByExample(filmCategoryExample);
		req.setAttribute("type", filmCategory.getTitle());
		req.setAttribute("filmCategory", filmCategory1);

		return "film/showCategoryFilm";
	}

	@RequestMapping("upload")
	public String upload(HttpServletRequest req) {

		FilmCategoryExample filmCategoryExample = new FilmCategoryExample();

		List<FilmCategory> filmCategory = filmCategoryMapper
				.selectByExample(filmCategoryExample);
		req.setAttribute("filmCategory", filmCategory);
		req.setAttribute("type", DetailType.FILM.getType());
		return "film/uploadFilm";
	}

	@RequestMapping("addFilmCategory")
	public String addFilmCategory(HttpServletRequest req) {
		req.setAttribute("type", DetailType.FILM.getType());
		return "film/addFilmCategory";
	}

	@RequestMapping("manageCategory")
	public String manageCategory(HttpServletRequest req, Integer page,
			String categoryName, HttpServletResponse res) {

		if (categoryName != null) {
			FilmCategory filmCategory = new FilmCategory();
			Date date = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH-mm-ss");
			String datecreated = simpleDateFormat.format(date);
			filmCategory.setDatecreated(datecreated);
			filmCategory.setDeleted(false);
			filmCategory.setTitle(categoryName);
			filmCategory.setTop(false);
			filmCategoryMapper.insert(filmCategory);

		}

		FilmCategoryExample filmCategoryExample = new FilmCategoryExample();
		filmCategoryExample.setOrderByClause("dateCreated DESC");

		page = page == null ? 1 : page;
		PageHelper.startPage(page, 20);
		List<FilmCategory> filmCategory = filmCategoryMapper
				.selectByExample(filmCategoryExample);

		req.setAttribute("data", new PageInfo<FilmCategory>(filmCategory));
		req.setAttribute("url", "manageCategory.action?id=");
		req.setAttribute("pageurl", "manageCategory.action?page=");
		req.setAttribute("type", DetailType.FILM.getType());
		return "film/manageCategory";
	}

	@RequestMapping("deleteCategory")
	@ResponseBody
	public JSONObject deleteCategory(Integer id) {
		JSONObject result = new JSONObject();

		if (id == null) {
			result.put("succ", 1);
			return result;
		}

		filmCategoryMapper.deleteByPrimaryKey(id);

		return result;

	}

	/*
	 * public String delete(HttpServletRequest req, Integer page, Integer id,
	 * HttpServletResponse res) {
	 * 
	 * 
	 * if (id != null) { filmMapper.deleteByPrimaryKey(id); }
	 * 
	 * FilmExample filmExample = new FilmExample();
	 * filmExample.setOrderByClause("createTime DESC");
	 * 
	 * page = page == null ? 1 : page; PageHelper.startPage(page, 20);
	 * List<Film> film = filmMapper.selectByExample(filmExample);
	 * 
	 * req.setAttribute("data", new PageInfo<Film>(film));
	 * req.setAttribute("url", "delete.action?id="); req.setAttribute("pageurl",
	 * "delete.action?page=");
	 * 
	 * 
	 * return "film/deleteFilm"; }
	 */
	@RequestMapping("delete")
	public String delete(HttpServletRequest req, Integer page,
			HttpServletResponse res) {

		FilmExample filmExample = new FilmExample();
		filmExample.setOrderByClause("createTime DESC");

		page = page == null ? 1 : page;
		PageHelper.startPage(page, 20);
		List<Film> film = filmMapper.selectByExample(filmExample);

		req.setAttribute("data", new PageInfo<Film>(film));
		req.setAttribute("url", "delete.action?id=");
		req.setAttribute("pageurl", "delete.action?page=");
		req.setAttribute("type", DetailType.FILM.getType());

		return "film/deleteFilm";
	}

	@RequestMapping("deleteFilm")
	@ResponseBody
	public JSONObject deleteFilm(Integer id) {
		JSONObject result = new JSONObject();
		if (id == null) {
			result.put("succ", 1);
			return result;
		}

		filmMapper.deleteByPrimaryKey(id);

		return result;
	}

	@RequestMapping("upload/uploadFilmFile")
	@ResponseBody
	public String uploadFilmFile(@RequestParam("files") MultipartFile[] files,
			HttpServletRequest request) throws IllegalStateException,
			IOException {
		MultipartFile filmFile = files[0];
		if (filmFile.getSize() != 0) {
			// 原始文件名
			String filmOriginalFilename = filmFile.getOriginalFilename();
			// 新的视频名称
			String filmFileName = UUID.randomUUID()
					+ filmOriginalFilename.substring(filmOriginalFilename
							.lastIndexOf("."));
			// 新的图片文件
			File newFilmFile = new File(VIRTUAL_FILM_PATH + filmFileName);
			// 将内存中的文件写入磁盘
			filmFile.transferTo(newFilmFile);
			return FILM_PATH + filmFileName;
		}
		return null;
	}

	@RequestMapping("filesUpload")
	public String filesUpload(@RequestParam("files") MultipartFile[] files,
			HttpServletRequest request, Film film)
			throws IllegalStateException, IOException {

		// 设定上传日期
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");// 创建格式化对象
		String dateStr = dateFormat.format(date);
		film.setCreatetime(dateStr);
		// 是否置顶电影
		film.setTop(false);

		MultipartFile imgFile = files[0];
		if (imgFile.getSize() != 0) {
			// 原始文件名
			String imgOriginalFilename = imgFile.getOriginalFilename();
			// 新的图片名称
			String imgFileName = UUID.randomUUID()
					+ imgOriginalFilename.substring(imgOriginalFilename
							.lastIndexOf("."));
			// 新的图片文件
			File newImgFile = new File(VIRTUAL_IMG_PATH + imgFileName);
			// 将内存中的文件写入磁盘
			imgFile.transferTo(newImgFile);
			film.setImgurl(IMG_PATH + imgFileName);
			// 返回上传成功标志
			request.setAttribute("isSuccess", 1);
		}

		filmMapper.insert(film);
		// return "redirect:upload.do";
		request.setAttribute("type", DetailType.FILM.getType());
		
		FilmCategoryExample filmCategoryExample = new FilmCategoryExample();

		List<FilmCategory> filmCategory = filmCategoryMapper
				.selectByExample(filmCategoryExample);
		request.setAttribute("filmCategory", filmCategory);
		
		return "film/uploadFilm";

	}

	@RequestMapping("modifyFilmUpload")
	public String modifyFilmUpload(HttpServletRequest req, Film film,
			MultipartFile files) throws IllegalStateException, IOException {

		// 设定上传日期
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");// 创建格式化对象
		String dateStr = dateFormat.format(date);
		film.setCreatetime(dateStr);
		
		if (files.getSize() != 0) {
			// 原始文件名
			String imgOriginalFilename = files.getOriginalFilename();
			// 新的图片名称
			String imgFileName = UUID.randomUUID()
					+ imgOriginalFilename.substring(imgOriginalFilename
							.lastIndexOf("."));
			// 新的图片文件
			File newImgFile = new File(VIRTUAL_IMG_PATH + imgFileName);
			// 将内存中的文件写入磁盘
			files.transferTo(newImgFile);
			film.setImgurl(IMG_PATH + imgFileName);
		}
	
		filmMapper.updateByPrimaryKeySelective(film);
		req.setAttribute("type", DetailType.FILM.getType());

		return "film/success";

	}

}

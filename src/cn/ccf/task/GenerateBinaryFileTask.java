package cn.ccf.task;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

import cn.ccf.mapper.MediaMapper;
import cn.ccf.pojo.Media;
import cn.ccf.utils.MyRTF2HTML;
import cn.ccf.utils.MyRead;

@Component
public class GenerateBinaryFileTask implements Runnable {

	@Autowired
	private MediaMapper mediaMapper;

	public void run() {

		List<Media> lis = mediaMapper.selectByFlags(false);

		for (Iterator iterator = lis.iterator(); iterator.hasNext();) {
			Media media = (Media) iterator.next();

			if (media.getSouceid() == 0) {
				Integer type = media.getType();
				String filePath = "d:\\upload\\" + type + "\\"
						+ media.getSouceid();
				String extension = media.getExtension();

				//String fileName = media.getRemark();
				String fileName = media.getId()+".jpg";

				MyRTF2HTML.getFile(media.getData(), filePath, fileName);
				media.setFlags(true);
				mediaMapper.updateByPrimaryKey(media);
				System.out.println("置顶图片执行。。。。");
			} else {

				Integer type = media.getType();
				String filePath = "d:\\upload\\" + type + "\\"
						+ media.getSouceid();
				int sourceID = media.getSouceid();

				String extension = media.getExtension();
				if (extension.equalsIgnoreCase("png")
						|| extension.equalsIgnoreCase("BMP")
						|| extension.equalsIgnoreCase("JPEG")
						|| extension.equalsIgnoreCase("GIF")) {

					String fileName = sourceID + ".jpg";
					String originalFileName = sourceID + "." + extension;
					MyRTF2HTML.getFile(media.getData(), filePath,
							originalFileName);

					MyRTF2HTML.getFile(media.getData(), filePath, fileName);
					media.setFlags(true);
					mediaMapper.updateByPrimaryKey(media);
					System.out.println("图片生成。。。。");
				} else {
					String fileName = sourceID + "." + extension;

					MyRTF2HTML.getFile(media.getData(), filePath, fileName);
					media.setFlags(true);
					mediaMapper.updateByPrimaryKey(media);

					System.out.println("附件生成。。。。");

					if (extension.equalsIgnoreCase("doc")) {

						try {
							String temp1 = filePath + "\\" + sourceID + ".html";
							String temp2 = filePath + "\\" + sourceID + ".doc";
							String temp3 = filePath + "\\";
							convert2Html(filePath + "\\" + sourceID + ".doc",
									filePath + "\\" + sourceID + ".html",
									filePath + "\\");
							// convert2Html("d://upload//260//9//9.doc","d://upload//260//9//9.html","d:\\upload\\260\\9\\");
							System.out.println("转换html成功");
						} catch (TransformerException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out.println("1");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							System.out.println("2");
							e.printStackTrace();
						} catch (ParserConfigurationException e) {
							System.out.println("3");
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}

			}

		}

	}

	public void writeFile(String content, String path) {
		FileOutputStream fos = null;
		BufferedWriter bw = null;
		try {
			File file = new File(path);
			fos = new FileOutputStream(file);
			bw = new BufferedWriter(new OutputStreamWriter(fos, "gb2312"));
			bw.write(content);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fos != null)
					fos.close();
			} catch (IOException ie) {
			}
		}
	}

	public void convert2Html(String fileName, String outPutFile, String imgPath)
			throws TransformerException, IOException,
			ParserConfigurationException {
		// InputStream stream = new FileInputStream(fileName);
		// new HWPFDocument(stream);//
		HWPFDocument wordDocument = new HWPFDocument(new FileInputStream(
				fileName));
		WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(
				DocumentBuilderFactory.newInstance().newDocumentBuilder()
						.newDocument());
		wordToHtmlConverter.setPicturesManager(new PicturesManager() {
			public String savePicture(byte[] content, PictureType pictureType,
					String suggestedName, float widthInches, float heightInches) {
				return suggestedName;
			}
		});
		wordToHtmlConverter.processDocument(wordDocument);
		// save pictures
		List pics = wordDocument.getPicturesTable().getAllPictures();
		if (pics != null) {
			for (int i = 0; i < pics.size(); i++) {
				Picture pic = (Picture) pics.get(i);
				System.out.println();
				try {
					String temp1 = pic.suggestFileExtension();
					String temp2 = pic.suggestFullFileName();
					pic.writeImageContent(new FileOutputStream(imgPath
							+ pic.suggestFullFileName()));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		Document htmlDocument = wordToHtmlConverter.getDocument();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		DOMSource domSource = new DOMSource(htmlDocument);
		StreamResult streamResult = new StreamResult(out);

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer serializer = tf.newTransformer();
		serializer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
		serializer.setOutputProperty(OutputKeys.INDENT, "yes");
		serializer.setOutputProperty(OutputKeys.METHOD, "html");
		serializer.transform(domSource, streamResult);
		out.close();
		writeFile(new String(out.toByteArray()), outPutFile);
	}

}

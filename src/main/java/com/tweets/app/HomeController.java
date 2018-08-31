package com.tweets.app;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tweets.util.HibernateUtil;
import com.tweets.model.SearchTextDb;
import com.tweets.model.Tweet;
import com.tweets.model.TweetDb;
import com.tweets.model.User;
import com.tweets.service.TokenService;
import com.tweets.service.TweetSearch;
import com.tweets.service.TwitterUser;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private TokenService tokenService;

	@Autowired
	private TweetSearch tweetSearch;

	@Autowired
	private TwitterUser twitterUserService;
	
	private static ResourceBundle rb = ResourceBundle.getBundle("application");

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
	public String home(Locale locale, Model model, @RequestParam(required = false) String searchText) {
		logger.info("Welcome home! The client locale is {}.", locale);

		try {

			if (searchText != null) {

				String bearerToken = this.getBearerToken();
				List<Tweet> tweets = tweetSearch.getSearchedTweets(bearerToken, searchText);
				logger.error(tweets.toString());
				model.addAttribute("tweets", tweets);
				
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction transaction = null;
				try {
					transaction = session.beginTransaction();
					
					/*Set<Phone> phoneNumbers = new HashSet<Phone>();
					phoneNumbers.add(new Phone("house","32354353"));
					phoneNumbers.add(new Phone("mobile","9889343423"));
					
					Student student = new Student("Eswar", phoneNumbers);
					session.save(student); */
					 SearchTextDb search = new SearchTextDb();
					 search.setSearchText(searchText);
					 session.save(search);
					
					 for(Tweet t: tweets) {
						 TweetDb tDb = new TweetDb();
						 tDb.setSearch(search);
						 tDb.setId_str(t.getId_str());
						 tDb.setText(t.getText());
						 tDb.setCreated_at(t.getCreated_at());
						 /*try(InputStream in = new URL(t.getEntities().).openStream()){
							    Files.copy(in, Paths.get("C:/File/To/Save/To/image.jpg"));
						 } */
						 session.save(tDb);
					 }
					 
					
					transaction.commit();
				} catch (HibernateException e) {
					transaction.rollback();
					e.printStackTrace();
				} finally {
					session.close();
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "home";
	}

	@RequestMapping(value = "/userprofile", method = RequestMethod.GET)
	public String userprofile(Locale locale, Model model, @RequestParam(required = true) String screenName) {
		logger.info("User profile", locale);

		try {

			if (screenName != null) {

				String bearerToken = this.getBearerToken();
				User userDetail = twitterUserService.getUserDetail(bearerToken, screenName);
				Tweet[] userTweets = twitterUserService.getUserTweets(bearerToken, screenName);
				model.addAttribute("userDetail", userDetail);
				model.addAttribute("userTweets", userTweets);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "userprofile";
	}

	@RequestMapping(value = "/location", method = RequestMethod.GET)
	public String location(Locale locale, Model model, @RequestParam(required = true) String q) {
		logger.info("Welcome home! The client locale is {}.", locale);

		try {

			if (q != null) {

				String bearerToken = this.getBearerToken();
				List<Tweet> tweets = tweetSearch.getSearchedTweets(bearerToken, q);
				logger.error(tweets.toString());
				model.addAttribute("tweets", tweets);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "location";
	}

	@RequestMapping(value = "/hashtag", method = RequestMethod.GET)
	public String hashtag(Locale locale, Model model, @RequestParam(required = true) String q) {
		logger.info("Welcome home! The client locale is {}.", locale);

		try {

			if (q != null) {

				String bearerToken = this.getBearerToken();
				List<Tweet> tweets = tweetSearch.getSearchedTweets(bearerToken, "#" + q);
				logger.error(tweets.toString());
				model.addAttribute("tweets", tweets);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "hashtag";
	}

	public String getBearerToken() throws Exception {
		
        String consumerKey = rb.getString("oauth.consumerKey");
        String consumerSecret = rb.getString("oauth.consumerSecret");
        String encodeKeys = tokenService.encodeKeys(consumerKey,consumerSecret);

		String bearerToken = tokenService.getBearerToken(encodeKeys);
		return bearerToken;
	}

}

package binarysearchandsorting;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

/**
 * Created by rahulmishra on 10/06/16.
 */
public class square {
    static int side;
    static int area;
    static int perimeter;

    public static void main (String[] args) throws java.lang.Exception
    {
        String uri = "http://in.goibibo.com/api/v1/offer/5100318084";
        String postParametrs = "{\"isactive\":\"True\"}";
        requestPOSTUrlJSON(uri,postParametrs);

    }



    public static String requestPOSTUrlJSON(String url, String postParameters) {

        HttpURLConnection urlConnection = null;

            try {
                // create connection
                URL urlToRequest = new URL(url);
                urlConnection = (HttpURLConnection) urlToRequest.openConnection();
                urlConnection.setConnectTimeout(60000);
                urlConnection.setReadTimeout(60000);

                // handle POST parameters
                if (postParameters != null) {



                    urlConnection.setDoOutput(true);
                    urlConnection.setRequestMethod("PUT");

//                    System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
//                    urlConnection.setRequestProperty("Host", "pigeon.goibibo.com");
//                    urlConnection.setRequestProperty( "Accept-Encoding", "" );

                    urlConnection.setRequestProperty("Authorization", "Basic aW5nb2liaWJvLm1vYmlsZTppbmdvaWJpYm9AMTIz");
                    urlConnection.setFixedLengthStreamingMode(postParameters.getBytes().length);
                    urlConnection.setRequestProperty("Content-Type",
                            "application/json");

                    //send the POST out
                    PrintWriter out = new PrintWriter(urlConnection.getOutputStream());
                    out.print(postParameters);
                    out.close();

                }

                // handle issues
                int statusCode = urlConnection.getResponseCode();

                InputStream in =
                        new BufferedInputStream(urlConnection.getInputStream());
                String reply;
                StringBuffer sb = new StringBuffer();
                int chr;
                while ((chr = in.read()) != -1) {
                    sb.append((char) chr);
                }
                reply = sb.toString();

                in.close();
                return reply;

            } catch (final MalformedURLException e) {

            } catch (final SocketTimeoutException e) {

            } catch (final ConnectException e) {

            } catch (Exception e) {

            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

        return null;
    }

}

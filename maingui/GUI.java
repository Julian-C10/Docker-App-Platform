import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.io.*;
import java.net.*;
import java.net.http.*;
import java.net.http.HttpRequest.*;
import java.net.http.HttpResponse.*;
import java.time.Duration;
import java.nio.file.Paths;
public class GUI 
{
    static String ipaddr = "";
    public static void main(String args[]) 
    {
        Map<String, String> env = System.getenv();
        ipaddr = env.get("DISPLAY");
        ipaddr = ipaddr.substring(0, ipaddr.length() - 2); // Remove :0 at the end

        JFrame frame = new JFrame("Julian's Toolbox");
        frame.setSize(270, 465); // w, h
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton RStudioButton = new JButton("RStudio");
        RStudioButton.setBounds(10, 10, 250, 25); // x, y, w, h
        RStudioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RStudioButtonEventHandler(evt);
            }
        });

        JButton SpyderButton = new JButton("Spyder");
        SpyderButton.setBounds(10, 45, 250, 25); // x, y, w, h
        SpyderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpyderButtonEventHandler(evt);
            }
        });

        JButton IBMSASButton = new JButton("IBMSAS");
        IBMSASButton.setBounds(10, 80, 250, 25); // x, y, w, h
        IBMSASButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IBMSASButtonEventHandler(evt);
            }
        });

        JButton GitButton = new JButton("Git");
        GitButton.setBounds(10, 115, 250, 25); // x, y, w, h
        GitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GitButtonEventHandler(evt);
            }
        });

        JButton JupyterNotebookButton = new JButton("Jupyter Notebook");
        JupyterNotebookButton.setBounds(10, 150, 250, 25); // x, y, w, h
        JupyterNotebookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JupyterNotebookButtonEventHandler(evt);
            }
        });

        JButton OrangeButton = new JButton("Orange");
        OrangeButton.setBounds(10, 185, 250, 25); // x, y, w, h
        OrangeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrangeButtonEventHandler(evt);
            }
        });

        JButton VSCodeButton = new JButton("VSCode");
        VSCodeButton.setBounds(10, 220, 250, 25); // x, y, w, h
        VSCodeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VSCodeButtonEventHandler(evt);
            }
        });

        JButton ApacheHadoopButton = new JButton("Apache Hadoop");
        ApacheHadoopButton.setBounds(10, 255, 250, 25); // x, y, w, h
        ApacheHadoopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApacheHadoopButtonEventHandler(evt);
            }
        });

        JButton ApacheSparkButton = new JButton("Apache Spark");
        ApacheSparkButton.setBounds(10, 290, 250, 25); // x, y, w, h
        ApacheSparkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApacheSparkButtonEventHandler(evt);
            }
        });

        JButton TableauButton = new JButton("Tableau");
        TableauButton.setBounds(10, 325, 250, 25); // x, y, w, h
        TableauButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TableauButtonEventHandler(evt);
            }
        });

        JButton SonarButton = new JButton("SonarQube / SonarScanner");
        SonarButton.setBounds(10, 360, 250, 25); // x, y, w, h
        SonarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SonarButtonEventHandler(evt);
            }
        });

        JButton TensorflowButton = new JButton("Tensorflow");
        TensorflowButton.setBounds(10, 395, 250, 25); // x, y, w, h
        TensorflowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TensorflowButtonEventHandler(evt);
            }
        });

        JButton MarkdownButton = new JButton("Markdown");
        MarkdownButton.setBounds(10, 430, 250, 25); // x, y, w, h
        MarkdownButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MarkdownButtonEventHandler(evt);
            }
        });

        frame.add(RStudioButton);
        frame.add(SpyderButton);
        frame.add(IBMSASButton);
        frame.add(GitButton);
        frame.add(JupyterNotebookButton);
        frame.add(OrangeButton);
        frame.add(VSCodeButton);
        frame.add(ApacheHadoopButton);
        frame.add(ApacheSparkButton);
        frame.add(TableauButton);
        frame.add(SonarButton);
        frame.add(TensorflowButton);
        frame.add(MarkdownButton);
        
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private static void makeRequest(String port, String url) {
        try {
            HttpClient client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(20))
            .build();

            HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://" + ipaddr + ":" + port + "/"))
            .header("theurl", url)
            .timeout(Duration.ofMinutes(1))
            .build();
            
            client.sendAsync(request, BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
            .thenAccept(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void RStudioButtonEventHandler(java.awt.event.ActionEvent evt) {
        makeRequest("5000", "http://" + ipaddr + ":8787/");
    }

    private static void SpyderButtonEventHandler(java.awt.event.ActionEvent evt) {
        makeRequest("5001", "");
    }

    private static void IBMSASButtonEventHandler(java.awt.event.ActionEvent evt) {
        makeRequest("5002", "https://welcome.oda.sas.com/login");
    }

    private static void GitButtonEventHandler(java.awt.event.ActionEvent evt) {
        makeRequest("5003", "");
    }

    private static void JupyterNotebookButtonEventHandler(java.awt.event.ActionEvent evt) {
        makeRequest("5004", "http://" + ipaddr + ":8888/?token=easy");
    }

    private static void OrangeButtonEventHandler(java.awt.event.ActionEvent evt) {
        makeRequest("5005", "");
    }

    private static void VSCodeButtonEventHandler(java.awt.event.ActionEvent evt) {
        makeRequest("5006", "http://" + ipaddr + ":8443/");
    }

    private static void ApacheHadoopButtonEventHandler(java.awt.event.ActionEvent evt) {
        makeRequest("5007", "");
    }

    private static void ApacheSparkButtonEventHandler(java.awt.event.ActionEvent evt) {
        makeRequest("5008", "");
    }

    private static void TableauButtonEventHandler(java.awt.event.ActionEvent evt) {
        makeRequest("5009", "https://public.tableau.com/en-us/s/");
    }

    private static void SonarButtonEventHandler(java.awt.event.ActionEvent evt) {
        makeRequest("5010", "http://" + ipaddr + ":9001/");
    }

    private static void TensorflowButtonEventHandler(java.awt.event.ActionEvent evt) {
        makeRequest("5011", "");
    }

    private static void MarkdownButtonEventHandler(java.awt.event.ActionEvent evt) {
        makeRequest("5012", "http://" + ipaddr + ":12345/");
    }
}
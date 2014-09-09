package com.example.helloworld.core;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Map;


public class MandrillRequest {

    @NotNull
    /*The API Key for the Mandrill account*/
    private String key;
    @NotNull
    /*The message to be sent*/
    private MandrillMessage message;

    /*enable a background sending mode that is optimized for bulk sending.
    In async mode, messages/send will immediately return a status of "queued" for every recipient.
    To handle rejections when sending in async mode, set up a webhook for the 'reject' event.
    Defaults to false for messages with no more than 10 recipients; messages with more than
    10 recipients are always sent asynchronously, regardless of the value of async.*/
    private boolean async;

    /*the name of the dedicated ip pool that should be used to send the message.
    If you do not have any dedicated IPs, this parameter has no effect.
    If you specify a pool that does not exist, your default pool will be used instead.*/
    private String ip_pool;

    /*when this message should be sent as a UTC timestamp in YYYY-MM-DD HH:MM:SS format.
    If you specify a time in the past, the message will be sent immediately.
    An additional fee applies for scheduled email, and this feature is only available
    to accounts with a positive balance.
    Validation: datetime*/
    private String send_at;

    public MandrillRequest(/*MandrillMessage message*/){

        //this is the API Key for the mandrill account
        this.key = "your mandrill api key";

        //set async to true as we are using all asynchronous processing and there is no way to guarantee the email has
        //been delivered once mandrill receives it, so an acknowledgement form mandrill that it is in queue is the best
        //we can do anyway
        this.async = true;



    }

    @JsonProperty
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @JsonProperty
    public MandrillMessage getMessage() {
        return message;
    }

    public void setMessage(MandrillMessage message) {
        this.message = message;
    }

    @JsonProperty
    public boolean isAsync() {
        return async;
    }

    public void setAsync(boolean async) {
        this.async = async;
    }

    @JsonProperty
    public String getIp_pool() {
        return ip_pool;
    }

    public void setIp_pool(String ip_pool) {
        this.ip_pool = ip_pool;
    }

    @JsonProperty
    public String getSend_at() {
        return send_at;
    }

    public void setSend_at(String send_at) {
        this.send_at = send_at;
    }

    public class MandrillMessage {


        /*the full HTML content to be sent*/
        private String html;

        /*optional full text content to be sent*/
        private String text;

        /*the message subject*/
        private String subject;

        /*the sender email address*/
        private String from_email;

        /*optional from name to be used*/
        private String from_name;

        @NotNull
        /*An array of recipient information*/
        private ArrayList<To> to;

        /*optional extra headers to add to the message (most headers are allowed)*/
        private Object headers;

        /*whether or not this message is important, and should be delivered ahead of non-important messages*/
        private boolean important;

        /*whether or not to turn on open tracking for the message*/
        private boolean track_opens;

        /*whether or not to turn on click tracking for the message*/
        private boolean track_clicks;

        /*whether or not to automatically generate a text part for messages that are not given text*/
        private boolean auto_text;

        /*whether or not to automatically generate an HTML part for messages that are not given HTML*/
        private boolean auto_html;

        /*whether or not to automatically inline all CSS styles provided in the message HTML
        - only for HTML documents less than 256KB in size*/
        private boolean inline_css;

        /*whether or not to strip the query string from URLs when aggregating tracked URL data*/
        private boolean url_strip_qs;

        /*whether or not to expose all recipients in to "To" header for each email*/
        private boolean preserve_recipients;

        /*set to false to remove content logging for sensitive emails*/
        private boolean view_content_link;

        /*an optional address to receive an exact copy of each recipient's email*/
        private String bcc_address;

        /*a custom domain to use for tracking opens and clicks instead of mandrillapp.com*/
        private String tracking_domain;

        /*a custom domain to use for SPF/DKIM signing instead of mandrill
        (for "via" or "on behalf of" in email clients)*/
        private String signing_domain;

        /*a custom domain to use for the messages's return-path*/
        private String return_path_domain;

        /*whether to evaluate merge tags in the message.
        Will automatically be set to true if either merge_vars or global_merge_vars are provided.*/
        private boolean merge;

        /*global merge variables to use for all recipients. You can override these per recipient.*/
        private ArrayList<GlobalMergeVars> global_merge_vars;

        /*per-recipient merge variables, which override global merge variables with the same name.*/
        private ArrayList<MergeVars> merge_vars;

        /*an array of string to tag the message with. Stats are accumulated using tags,
        though we only store the first 100 we see, so this should not be unique or change frequently.
        Tags should be 50 characters or less. Any tags starting with an underscore are reserved for
        internal use and will cause errors.*/
        private ArrayList<String> tags;

        /*the unique id of a subaccount for this message - must already exist or will fail with an error*/
        private String subaccount;

        /*an array of strings indicating for which any matching URLs will automatically have Google Analytics
         parameters appended to their query string automatically.*/
        private ArrayList<String> google_analytics_domains;

        /*optional string indicating the value to set for the utm_campaign tracking parameter.
        If this isn't provided the email's from address will be used instead.*/
        private String google_analytics_campaign;

        /*metadata an associative array of user metadata. Mandrill will store this metadata and make
        it available for retrieval. In addition, you  can select up to 10 metadata fields to index and
        make searchable using the Mandrill search api.*/
        private Map<String, String> metadata;

        /*Per-recipient metadata that will override the global values specified in the metadata parameter.*/
        private ArrayList<Map<String,String>> recipient_metadata;

        /*an array of supported attachments to add to the message*/
        private ArrayList<Attachments> attachments;

        /*an array of embedded images to add to the message*/
        private ArrayList<Images> images;


        /*constructor to build a default simple message*/
        public MandrillMessage(String html,String subject,String from_email,String from_name,
                               String email ){
            this.html = html;
            this.subject = subject;
            this.from_email = from_email;
            this.from_name = from_name;
            this.setTo(email);
        }

        @JsonProperty
        public String getHtml() {
            return html;
        }


        public void setHtml(String html) {
            this.html = html;
        }

        @JsonProperty
        public String getText() {
            return text;
        }


        public void setText(String text) {
            this.text = text;
        }

        @JsonProperty
        public String getSubject() {
            return subject;
        }


        public void setSubject(String subject) {
            this.subject = subject;
        }

        @JsonProperty
        public String getFrom_email() {
            return from_email;
        }


        public void setFrom_email(String from_email) {
            this.from_email = from_email;
        }

        @JsonProperty
        public String getFrom_name() {
            return from_name;
        }


        public void setFrom_name(String from_name) {
            this.from_name = from_name;
        }

        @JsonProperty
        public ArrayList<To> getTo() {
            return to;
        }

        public void setTo(String email) {

            ArrayList<To> toList = new ArrayList<To>();
            To toEmail = new To(email);
            toList.add(toEmail);

            this.to = toList;
        }

        @JsonProperty
        public Object getHeaders() {
            return headers;
        }

        public void setHeaders(Object headers) {
            this.headers = headers;
        }

        @JsonProperty
        public boolean isImportant() {
            return important;
        }

        public void setImportant(boolean important) {
            this.important = important;
        }

        @JsonProperty
        public boolean isTrack_opens() {
            return track_opens;
        }

        public void setTrack_opens(boolean track_opens) {
            this.track_opens = track_opens;
        }

        @JsonProperty
        public boolean isTrack_clicks() {
            return track_clicks;
        }

        public void setTrack_clicks(boolean track_clicks) {
            this.track_clicks = track_clicks;
        }

        @JsonProperty
        public boolean isAuto_text() {
            return auto_text;
        }

        public void setAuto_text(boolean auto_text) {
            this.auto_text = auto_text;
        }

        @JsonProperty
        public boolean isAuto_html() {
            return auto_html;
        }

        public void setAuto_html(boolean auto_html) {
            this.auto_html = auto_html;
        }

        @JsonProperty
        public boolean isInline_css() {
            return inline_css;
        }

        public void setInline_css(boolean inline_css) {
            this.inline_css = inline_css;
        }

        @JsonProperty
        public boolean isUrl_strip_qs() {
            return url_strip_qs;
        }

        public void setUrl_strip_qs(boolean url_strip_qs) {
            this.url_strip_qs = url_strip_qs;
        }

        @JsonProperty
        public boolean isPreserve_recipients() {
            return preserve_recipients;
        }

        public void setPreserve_recipients(boolean preserve_recipients) {
            this.preserve_recipients = preserve_recipients;
        }

        @JsonProperty
        public boolean isView_content_link() {
            return view_content_link;
        }

        public void setView_content_link(boolean view_content_link) {
            this.view_content_link = view_content_link;
        }

        @JsonProperty
        public String getBcc_address() {
            return bcc_address;
        }

        public void setBcc_address(String bcc_address) {
            this.bcc_address = bcc_address;
        }

        @JsonProperty
        public String getTracking_domain() {
            return tracking_domain;
        }

        public void setTracking_domain(String tracking_domain) {
            this.tracking_domain = tracking_domain;
        }

        @JsonProperty
        public String getSigning_domain() {
            return signing_domain;
        }

        public void setSigning_domain(String signing_domain) {
            this.signing_domain = signing_domain;
        }

        @JsonProperty
        public String getReturn_path_domain() {
            return return_path_domain;
        }

        public void setReturn_path_domain(String return_path_domain) {
            this.return_path_domain = return_path_domain;
        }

        @JsonProperty
        public boolean isMerge() {
            return merge;
        }

        public void setMerge(boolean merge) {
            this.merge = merge;
        }

        @JsonProperty
        public ArrayList<GlobalMergeVars> getGlobal_merge_vars() {
            return global_merge_vars;
        }

        public void setGlobal_merge_vars(ArrayList<GlobalMergeVars> global_merge_vars) {
            this.global_merge_vars = global_merge_vars;
        }

        @JsonProperty
        public ArrayList<MergeVars> getMerge_vars() {
            return merge_vars;
        }

        public void setMerge_vars(ArrayList<MergeVars> merge_vars) {
            this.merge_vars = merge_vars;
        }

        @JsonProperty
        public ArrayList<String> getTags() {
            return tags;
        }

        public void setTags(ArrayList<String> tags) {
            this.tags = tags;
        }

        @JsonProperty
        public String getSubaccount() {
            return subaccount;
        }

        public void setSubaccount(String subaccount) {
            this.subaccount = subaccount;
        }

        @JsonProperty
        public ArrayList<String> getGoogle_analytics_domains() {
            return google_analytics_domains;
        }

        public void setGoogle_analytics_domains(ArrayList<String> google_analytics_domains) {
            this.google_analytics_domains = google_analytics_domains;
        }

        @JsonProperty
        public String getGoogle_analytics_campaign() {
            return google_analytics_campaign;
        }

        public void setGoogle_analytics_campaign(String google_analytics_campaign) {
            this.google_analytics_campaign = google_analytics_campaign;
        }

        @JsonProperty
        public Map<String, String> getMetadata() {
            return metadata;
        }

        public void setMetadata(Map<String, String> metadata) {
            this.metadata = metadata;
        }

        @JsonProperty
        public ArrayList<Map<String, String>> getRecipient_metadata() {
            return recipient_metadata;
        }

        public void setRecipient_metadata(ArrayList<Map<String, String>> recipient_metadata) {
            this.recipient_metadata = recipient_metadata;
        }

        @JsonProperty
        public ArrayList<Attachments> getAttachments() {
            return attachments;
        }

        public void setAttachments(ArrayList<Attachments> attachments) {
            this.attachments = attachments;
        }

        @JsonProperty
        public ArrayList<Images> getImages() {
            return images;
        }

        public void setImages(ArrayList<Images> images) {
            this.images = images;
        }

        /*a single recipient's information.*/
        public class To {
            @NotNull
            /*the email address of the recipient required*/
            private String email;

            /*the optional display name to use for the recipient*/
            private String name;

            /*the header type to use for the recipient, defaults to "to" if not provided oneof(to, cc, bcc)*/
            private String type;

            public To(String email){

                this.email  = email;
                this.name = "";
                this.type = "to";

            }

            @JsonProperty
            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            @JsonProperty
            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            @JsonProperty
            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        /*a single global merge variable*/
        public class GlobalMergeVars{

            /*the global merge variable's name. Merge variable names are case-insensitive and may not start with _*/
            private String name;

            /*the global merge variable's content*/
            private String content;

            public GlobalMergeVars(){
                //jackson de-serialization
            }

            @JsonProperty
            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            @JsonProperty
            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }

        /*a single per-recipient merge variable*/
        public class MergeVars{

            /*the email address of the recipient that the merge variables should apply to required*/
            @NotNull
            private String rcpt;

            /*the recipient's merge variables*/
            private ArrayList<GlobalMergeVars> vars;

            public MergeVars(){
                //jackson de-serialization

            }

            @JsonProperty
            public String getRcpt() {
                return rcpt;
            }

            public void setRcpt(String rcpt) {
                this.rcpt = rcpt;
            }

            @JsonProperty
            public ArrayList<GlobalMergeVars> getVars() {
                return vars;
            }

            public void setVars(ArrayList<GlobalMergeVars> vars) {
                this.vars = vars;
            }
        }

        /*a single supported attachment*/
        public class Attachments{

            /*the MIME type of the attachment*/
            private String type;

            /*the file name of the attachment*/
            private String name;

            /*the content of the attachment as a base64-encoded string*/
            private String content;

            public Attachments(){
                //jackson de-serialization

            }

            @JsonProperty
            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            @JsonProperty
            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            @JsonProperty
            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }

        /*a single embedded image*/
        public class Images{

            /*the MIME type of the image - must start with "image/"*/
            private String type;

            /*the Content ID of the image - use <img src="cid:THIS_VALUE"> to reference the image in your HTML content*/
            private String name;

            /*the content of the image as a base64-encoded string*/
            private String content;

            public Images(){
                //jackson de-serialization
            }

            @JsonProperty
            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            @JsonProperty
            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            @JsonProperty
            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }
    }


}

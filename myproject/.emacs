
(global-font-lock-mode t)
(line-number-mode t)
(setq display-time-24hr-format nil)
(display-time)
(menu-bar-mode nil)
(xterm-mouse-mode t)
(transient-mark-mode t)
(setq inhibit-startup-message t)

(define-key global-map (kbd "RET") 'newline-and-indent)


;;color themes
;;(setq load-path (cons "~/src/lisp/color-theme-6.6.0" load-path))
;;(require 'color-theme)
;;(color-theme-initialize)
;; ;(color-theme-high-contrast)
;; ;(color-theme-dark-laptop)
;; ;(color-theme-late-night)
;; (color-theme-goldenrod)




;;; This was installed by package-install.el.
;;; This provides support for the package system and
;;; interfacing with ELPA, the package archive.
;;; Move this code earlier if you want to reference
;;; packages in your .emacs.
(when
    (load
     (expand-file-name "~/.emacs.d/elpa/package.el"))
  (package-initialize))


;; lein swank
 (defun lein-swank () 
   (interactive) 
   (let ((root (locate-dominating-file default-directory "project.clj"))) 
     (when (not root) 
       (error "Not in a Leiningen project.")) 
     ;; you can customize slime-port using .dir-locals.el 
     (shell-command (format "cd %s && lein swank %s &" root slime-port) 
                    "*lein-swank*") 
     (set-process-filter (get-buffer-process "*lein-swank*") 
                         (lambda (process output) 
                           (when (string-match "Connection opened on" output) 
;;                             (slime-connect "localhost" slime-port) 
                             (set-process-filter process nil)))) 
     (message "Starting swank server...")))

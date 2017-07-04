'use strict';

var util = require('util');
var path = require('path');
var yeoman = require('yeoman-generator');
var yosay = require('yosay');
var chalk = require('chalk');

module.exports = yeoman.extend({
    initializing: function() {
        this.answers = {};
    },
    prompting: function() {
        var done = this.async();
        var prompts = [{
            type: 'input',
            name: 'com_name',
            message: 'Please input com name:',
            default: 'pkglcom'
        }, {
            type: 'input',
            name: 'model_name',
            message: 'Please input model name:',
            default: 'Pkpc'
        }];
        return this.prompt(prompts).then(function(answers) {
            this.answers = answers;
            done();
        }.bind(this));
    },

    configuring: function() {
        this.config.save();
    },

    selfFunction: function() {
        this.log("执行了自定义方法");
    },

    writing: function() {
        var fileTitle = this.answers.model_name.toLowerCase().replace(/(\w)/, function(v) {
            return v.toUpperCase()
        });
        var beanTitle = this.answers.model_name.toLowerCase();

        /**
         * 创建po实体和result
         */
        this.fs.copyTpl(
            this.templatePath('po.java'),
            this.destinationPath('public/po/' + fileTitle + '.java'), {
                fileTitle: fileTitle,
                beanTitle: beanTitle,
                com: this.answers.com_name
            }
        );
        this.fs.copyTpl(
            this.templatePath('poResult.java'),
            this.destinationPath('public/po/' + fileTitle + 'Result.java'), {
                fileTitle: fileTitle,
                beanTitle: beanTitle,
                com: this.answers.com_name
            }
        );

        /**
         * 创建dao及实现类
         */
        this.fs.copyTpl(
            this.templatePath('daoImpl.java'),
            this.destinationPath('public/dao/impl/' + fileTitle + 'DaoImpl.java'), {
                fileTitle: fileTitle,
                beanTitle: beanTitle,
                com: this.answers.com_name
            }
        );
        this.fs.copyTpl(
            this.templatePath('dao.java'),
            this.destinationPath('public/dao/' + fileTitle + 'Dao.java'), {
                fileTitle: fileTitle,
                beanTitle: beanTitle,
                com: this.answers.com_name
            }
        );

        /**
         * 创建service及实现类
         */
        this.fs.copyTpl(
            this.templatePath('service.java'),
            this.destinationPath('public/service/' + fileTitle + 'Service.java'), {
                fileTitle: fileTitle,
                beanTitle: beanTitle,
                com: this.answers.com_name
            }
        );
        this.fs.copyTpl(
            this.templatePath('serviceImpl.java'),
            this.destinationPath('public/service/impl/' + fileTitle + 'ServiceImpl.java'), {
                fileTitle: fileTitle,
                beanTitle: beanTitle,
                com: this.answers.com_name
            }
        );

        /**
         * 创建ws服务类
         */
        this.fs.copyTpl(
            this.templatePath('queryWS.java'),
            this.destinationPath('public/ws/' + fileTitle + 'QueryWebService.java'), {
                fileTitle: fileTitle,
                beanTitle: beanTitle,
                com: this.answers.com_name
            }
        );

    }
});

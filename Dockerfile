FROM ruby:2.7

# throw errors if Gemfile has been modified since Gemfile.lock
RUN bundle config --global frozen 1

COPY app /usr/src/app
WORKDIR /usr/src/app
RUN bundle install

EXPOSE 8080
CMD ["ruby","app.rb"]


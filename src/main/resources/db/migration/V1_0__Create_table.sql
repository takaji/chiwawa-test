create table company (
  company_id text not null,
  company_name text not null,
  api_base_url text not null,
  chiwawa_api_base_url text not null,
  chiwawa_custom_url_scheme text not null,
  client_id text not null,
  client_secret text not null,
  updated_at timestamp with time zone not null,
  created_at timestamp with time zone not null,
    primary key (company_id)
);

create table session (
  company_id text not null,
  login_id text not null,
  access_token text not null,
  updated_at timestamp with time zone not null,
  created_at timestamp with time zone not null,
  primary key (company_id, login_id)
);

create table user_profile (
  user_id text not null,
  company_id text not null,
  login_id text not null,
  user_name text not null,
  user_name_kana text,
  user_name_en text,
  updated_at timestamp with time zone not null,
  created_at timestamp with time zone not null,
  primary key (user_id)
)
